package com.iiitb.poshak.logging;


import org.apache.logging.log4j.util.Strings;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

@Service
public class LoggingService {

    @Resource
    private LoggingRepository loggingRepository;

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

    public Logging getLogsByFilter(LoggingFilterRequest filter) throws Exception {
        Long startTime = null;
        Long millisInDay = 24L * 60L * 60L * 100L;
        Long endTime = System.currentTimeMillis();

        if (Strings.isBlank(filter.getEmail())) {
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

        AggregationResults<Logging> userLogs = loggingRepository.aggregateLogsByTime(startTime, endTime, filter.getEmail());
        return userLogs.getUniqueMappedResult();
    }
}
