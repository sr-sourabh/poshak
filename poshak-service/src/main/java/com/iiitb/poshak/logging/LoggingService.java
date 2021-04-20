package com.iiitb.poshak.logging;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

//    public User setUser(UserRequest userRequest) {
//        User user = new User();
//        user.setEmailId(userRequest.getEmailId());
//        user.setPassword(userRequest.getPassword());
//        user.setStatus(1);
//        user.setName(userRequest.getName());
//        user.setHeight(userRequest.getHeight());
//        user.setWeight(userRequest.getWeight());
//
//
//        return userRepository.save(user);
//    }
