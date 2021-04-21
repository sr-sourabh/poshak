package com.iiitb.poshak.logging;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class LoggingService {

    @Resource
    private LoggingRepository loggingRepository;

    public Logging setlog(LoggingRequest loggingRequest) {

        Log log = new Log();
        log.setId(loggingRequest.getId());
        log.setCalorie(loggingRequest.getCalorie());
        log.setProtein(loggingRequest.getProtein());
        log.setFat(loggingRequest.getFat());
        log.setCarbs(loggingRequest.getCarbs());
        log.setDay(loggingRequest.getDay());
        log.setMonth(loggingRequest.getMonth());
        log.setYear(loggingRequest.getYear());

        Logging logging = loggingRepository.findByEmail(loggingRequest.getEmail());

        logging.getLog().add(log);

        logging = loggingRepository.save(logging);

        return logging;
    }

    public Logging getlog(LoggingRequest loggingRequest) {

        Logging logging = loggingRepository.findByEmail(loggingRequest.getEmail());
        return logging;

    }
}
