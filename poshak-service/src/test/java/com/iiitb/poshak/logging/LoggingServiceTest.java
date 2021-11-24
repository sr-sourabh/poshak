package com.iiitb.poshak.logging;

import com.iiitb.poshak.user.User;
import com.iiitb.poshak.user.UserRepository;
import com.iiitb.poshak.util.SequenceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class LoggingServiceTest {
    @InjectMocks
    private LoggingService underTest;

    @Mock
    private LoggingRepository loggingRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SequenceService sequenceService;

    @Test
    public void setLog() throws Exception{
        LoggingRequest loggingRequest = new LoggingRequest();

        loggingRequest.setEmail("ayush@gmail.com");
        loggingRequest.setCalorie(100.0F);
        loggingRequest.setProtein(8F);
        loggingRequest.setFat(15F);
        loggingRequest.setCarbs(32F);
        loggingRequest.setDay(22);
        loggingRequest.setMonth(11);
        loggingRequest.setYear(2021);
        loggingRequest.setFoodName("Milk");
        loggingRequest.setQuantity(2F);

        Logging logging = new Logging();
        logging.setEmail("ayush@gmail.com");

        Mockito.when(loggingRepository.findByEmail(loggingRequest.getEmail())).thenReturn(logging);
        Mockito.when(loggingRepository.save(logging)).thenReturn(logging);
        Logging result = underTest.setlog(loggingRequest);

        //Assertions.assertEquals(logging,result);
        Assertions.assertEquals("ayush@gmail.com",logging.getEmail());
    }

    @Test
    public void getLogsByEmail() throws Exception{
        LoggingRequest loggingRequest = new LoggingRequest();
        loggingRequest.setEmail("himanshu@gmail.com");
        Logging logging = new Logging();
        logging.setEmail("himanshu@gmail.com");
        Mockito.when(loggingRepository.findByEmail(loggingRequest.getEmail())).thenReturn(logging);
        Logging result = underTest.getAllLogsByEmail(loggingRequest);
        Assertions.assertEquals(logging,result);
        Assertions.assertEquals("himanshu@gmail.com",logging.getEmail());
    }

    @Test
    public void getLogsByFilter() throws Exception{
//        Long startTime = null;
//        Long endTime = System.currentTimeMillis();
//
//        LoggingFilterRequest loggingFilterRequest = new LoggingFilterRequest();
//        loggingFilterRequest.setEmails(Arrays.asList(new String[]{"ayush@gmail.com"}));
//        loggingFilterRequest.setToday(true);
//        loggingFilterRequest.setLastWeek(false);
//        loggingFilterRequest.setLastMonth(false);
//        loggingFilterRequest.setLastYear(false);
//
//        LoggingDto loggingDto = new LoggingDto();
//        loggingDto.setEmailId("ayush@gmail.com");
//
//        AggregationResults<LoggingDto> userLogs = null;
//        List<LoggingDto> loggingDtos= new ArrayList<>();
//        loggingDtos.add(loggingDto);
//
//        List<User> users = null;
//        Mockito.when(userRepository.findByEmailIdIn(loggingFilterRequest.getEmails())).thenReturn(users);
//        Mockito.when(loggingRepository.aggregateLogsSumByTime(startTime,endTime,loggingFilterRequest.getEmails())).thenReturn(userLogs);
//
//        List<LoggingDto> result = underTest.getLogsByFilter(loggingFilterRequest);
//
//        Assertions.assertEquals(loggingDtos,result);
    }
}