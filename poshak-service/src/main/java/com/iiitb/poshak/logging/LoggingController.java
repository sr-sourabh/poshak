package com.iiitb.poshak.logging;


import com.iiitb.poshak.user.User;
import com.iiitb.poshak.user.UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoggingController {

    @Resource
    private LoggingService loggingService;

    @PutMapping(value = "/logging/log")
    public Logging setlog(@RequestBody LoggingRequest loggingRequest) {
        Logging logging = loggingService.setlog(loggingRequest);
        return logging;
    }

    @PutMapping(value = "/logging/get")
    public Logging getlog(@RequestBody LoggingRequest loggingRequest) {
        Logging logging = loggingService.getlog(loggingRequest);
        return logging;
    }
}


