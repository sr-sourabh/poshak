package com.iiitb.poshak.logging;


import com.iiitb.poshak.user.User;
import com.iiitb.poshak.user.UserRepository;
import com.iiitb.poshak.util.SequenceService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static com.iiitb.poshak.util.Commons.LOG_SEQUENCE;

@Service
public class LoggingService {

    @Resource
    private LoggingRepository loggingRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private SequenceService sequenceService;

    @Transactional
    public Logging setlog(LoggingRequest loggingRequest) throws Exception {

        Log log = new Log();
        log.setId(sequenceService.getSequenceNextVal(LOG_SEQUENCE));
        log.setCalorie(loggingRequest.getCalorie());
        log.setProtein(loggingRequest.getProtein());
        log.setFat(loggingRequest.getFat());
        log.setCarbs(loggingRequest.getCarbs());
        log.setDate(System.currentTimeMillis());
        log.setFoodName(loggingRequest.getFoodName());
        log.setQuantity(loggingRequest.getQuantity());

        if (Strings.isBlank(loggingRequest.getEmail())) {
            throw new Exception("Email should not blank");
        }

        Logging logging = loggingRepository.findByEmail(loggingRequest.getEmail());
        if (Objects.isNull(logging)) {
            throw new Exception("Logging info not found");
        }
        logging.getLog().add(log);
        logging = loggingRepository.save(logging);

        return logging;
    }

    public Logging getAllLogsByEmail(LoggingRequest loggingRequest) throws Exception {
        if (Strings.isBlank(loggingRequest.getEmail())) {
            throw new Exception("Email should not blank");
        }

        Logging logging = loggingRepository.findByEmail(loggingRequest.getEmail());

        if (Objects.isNull(logging)) {
            throw new Exception("Email id not found for logging");
        }

        return logging;
    }

    public List<LoggingDto> getLogsByFilter(LoggingFilterRequest filter) throws Exception {
        Long startTime = null;
        Long millisInDay = 24L * 60L * 60L * 1000L;
        Long endTime = System.currentTimeMillis();

        if (CollectionUtils.isEmpty(filter.getEmails())) {
            throw new Exception("Please provide email");
        }

        if (filter.isToday()) {
            ZonedDateTime startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault());
            startTime = startOfToday.toEpochSecond() * 1000;
        } else if (filter.isLastWeek()) {
            startTime = endTime - 7 * millisInDay;
        } else if (filter.isLastMonth()) {
            startTime = endTime - 30 * millisInDay;
        } else if (filter.isLastYear()) {
            startTime = endTime - 365 * millisInDay;
        } else if (Objects.nonNull(filter.getStartTime())) {
            startTime = filter.getStartTime();
            if (Objects.nonNull(filter.getEndTime())) {
                endTime = filter.getEndTime();
            }
        } else {
            throw new Exception("Please specify a filter");
        }

        List<User> users = userRepository.findByEmailIdIn(filter.getEmails());
        if (CollectionUtils.isEmpty(users)) {
            throw new Exception("Users not found. Contact admin");
        }

        // key = email
        Map<String, User> userMap = new HashMap<>();
        users.forEach(user -> userMap.put(user.getEmailId(), user));

        AggregationResults<LoggingDto> userLogs = loggingRepository.aggregateLogsSumByTime(startTime, endTime, filter.getEmails());
        List<LoggingDto> loggingDtos = new ArrayList<>(userLogs.getMappedResults());
        Map<String, LoggingDto> loggingDtoMap = new HashMap<>();
        loggingDtos.forEach(loggingDto -> {
            loggingDtoMap.put(loggingDto.getEmailId(), loggingDto);
        });

        for (String emailId : userMap.keySet()) {
            User user = userMap.get(emailId);
            Long duration = (long) (Math.ceil(((double) (endTime - startTime) / millisInDay)));
            LoggingDto loggingDto = loggingDtoMap.get(emailId);
            if (Objects.isNull(loggingDto)) {
                loggingDto = new LoggingDto();
                loggingDtos.add(loggingDto);
            }
            loggingDto.setEmailId(user.getEmailId());
            loggingDto.setUserId(user.getId());
            loggingDto.setUserName(user.getName());
            loggingDto.setCarbsGoal(user.getCarbsGoal() * duration);
            loggingDto.setFatGoal(user.getFatGoal() * duration);
            loggingDto.setProteinGoal(user.getProteinGoal() * duration);
            loggingDto.setCalorieGoal(user.getCalorieGoal() * duration);

        }

        return loggingDtos;
    }
}
