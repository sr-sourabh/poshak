package com.iiitb.poshak.logging;


import com.iiitb.poshak.util.ErrorDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LoggingController {

    private static final Logger log = LogManager.getLogger(LoggingController.class);

    @Resource
    private LoggingService loggingService;

    @ExceptionHandler(Exception.class)
    public ErrorDto handleException(Exception e) {
        log.error(e.getStackTrace());
        ErrorDto errorDto = new ErrorDto();
        errorDto.getError().add(e.getMessage());
        errorDto.setExceptionId("IE-" + System.currentTimeMillis());
        return errorDto;
    }

    @PutMapping(value = "/logging/log")
    public Logging setlog(@RequestBody LoggingRequest loggingRequest) throws Exception {
        log.info("Set log request: {}", loggingRequest);
        Logging logging = loggingService.setlog(loggingRequest);
        return logging;
    }

    @PutMapping(value = "/logging/get")
    public Logging getAllLogsByEmail(@RequestBody LoggingRequest loggingRequest) throws Exception {
        log.info("getAllLogs by email request: {}", loggingRequest);
        Logging logging = loggingService.getAllLogsByEmail(loggingRequest);
        return logging;
    }

    @PutMapping(value = "/logging/filter")
    public List<LoggingDto> getLogsByFilter(@RequestBody LoggingFilterRequest loggingFilterRequest) throws Exception {
        log.info("getLogsByFilter request: {}", loggingFilterRequest);
        return loggingService.getLogsByFilter(loggingFilterRequest);
    }
}


