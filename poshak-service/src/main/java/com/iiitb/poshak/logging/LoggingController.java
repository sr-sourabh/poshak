package com.iiitb.poshak.logging;


import com.iiitb.poshak.util.ErrorDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoggingController {

    @Resource
    private LoggingService loggingService;

    @ExceptionHandler(Exception.class)
    public ErrorDto handleException(Exception e) {
        e.printStackTrace();
        ErrorDto errorDto = new ErrorDto();
        errorDto.getError().add(e.getMessage());
        return errorDto;
    }

    @PutMapping(value = "/logging/log")
    public Logging setlog(@RequestBody LoggingRequest loggingRequest) throws Exception {
        Logging logging = loggingService.setlog(loggingRequest);
        return logging;
    }

    @PutMapping(value = "/logging/get")
    public Logging getAllLogsByEmail(@RequestBody LoggingRequest loggingRequest) throws Exception {
        Logging logging = loggingService.getAllLogsByEmail(loggingRequest);
        return logging;
    }

    @PutMapping(value = "/logging/filter")
    public Logging getLogsByFilter(@RequestBody LoggingFilterRequest loggingFilterRequest) throws Exception {
        return loggingService.getLogsByFilter(loggingFilterRequest);
    }
}


