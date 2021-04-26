package com.iiitb.poshak.logging;


import com.iiitb.poshak.kafka.ProducerController;
import com.iiitb.poshak.user.User;
import com.iiitb.poshak.user.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Service
public class LoggingService {

    @Resource
    private LoggingRepository loggingRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ProducerController producerController;

    public Logging setlog(LoggingRequest loggingRequest) throws Exception {

        Log log = new Log();
        log.setId(loggingRequest.getId());
        log.setCalorie(loggingRequest.getCalorie());
        log.setProtein(loggingRequest.getProtein());
        log.setFat(loggingRequest.getFat());
        log.setCarbs(loggingRequest.getCarbs());
        log.setDate(System.currentTimeMillis());

        if (Strings.isBlank(loggingRequest.getEmail())) {
            throw new Exception("Email should not blank");
        }

        Logging logging = loggingRepository.findByEmail(loggingRequest.getEmail());
        if (Objects.isNull(logging)) {
            throw new Exception("Logging info not found");
        }
        logging.getLog().add(log);
        logging = loggingRepository.save(logging);

        LoggingFilterRequest request = new LoggingFilterRequest();
        List<String> emails = new ArrayList<>();
        emails.add(loggingRequest.getEmail());
        request.setEmails(emails);
        request.setLastWeek(true);
        LoggingDto loggingDto = getLogsByFilter(request).get(0);
        producerController.postUserInfoToKafka(loggingDto);

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
        List<LoggingDto> loggingDtos = userLogs.getMappedResults();
        for (LoggingDto loggingDto : loggingDtos) {
            if (Objects.nonNull(loggingDto)) {
                User user = userMap.get(loggingDto.getEmailId());
                Long duration = (long) (Math.ceil((double) ((endTime - startTime) / millisInDay)));
                loggingDto.setUserId(user.getId());
                loggingDto.setUserName(user.getName());
                loggingDto.setCarbsGoal(user.getCarbsGoal() * duration);
                loggingDto.setFatGoal(user.getFatGoal() * duration);
                loggingDto.setProteinGoal(user.getProteinGoal() * duration);
                loggingDto.setCalorieGoal(user.getCalorieGoal() * duration);
            }
        }

        return loggingDtos;
    }
}
