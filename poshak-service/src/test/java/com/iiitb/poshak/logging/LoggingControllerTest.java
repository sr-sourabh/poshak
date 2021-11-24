package com.iiitb.poshak.logging;

import com.iiitb.poshak.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
//import sun.util.logging.resources.logging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class LoggingControllerTest {
    @InjectMocks
    private LoggingController underTest;

    @Mock
    private LoggingService loggingService;


    //    getLogsByFilter

    @Test
    public void getlogbyfilter() throws Exception {

        LoggingFilterRequest loggingFilterRequest = new LoggingFilterRequest();
        loggingFilterRequest.setEmails(Arrays.asList(new String[]{"ayush@gmail.com"}));
        loggingFilterRequest.setToday(true);
        loggingFilterRequest.setLastWeek(false);
        loggingFilterRequest.setLastMonth(false);
        loggingFilterRequest.setLastYear(false);

        LoggingDto loggingDto = new LoggingDto();
        loggingDto.setEmailId("ayush@gmail.com");
        List<LoggingDto> loggingDtos= new ArrayList<>();
        loggingDtos.add(loggingDto);

        Mockito.when(loggingService.getLogsByFilter(loggingFilterRequest)).thenReturn(loggingDtos);

        List<LoggingDto> result = underTest.getLogsByFilter(loggingFilterRequest);

        Assertions.assertEquals(loggingDtos,result);


    }

    @Test
    public void getlog() throws Exception {

        LoggingRequest loggingRequest = new LoggingRequest();
        loggingRequest.setEmail("ayush@gmail.com");

        Logging logging = new Logging();
        logging.setEmail("ayush@gmail.com");

        Mockito.when(loggingService.getAllLogsByEmail(loggingRequest)).thenReturn(logging);

        Logging result = underTest.getAllLogsByEmail(loggingRequest);

        Assertions.assertEquals(logging,result);
        Assertions.assertEquals("ayush@gmail.com",logging.getEmail());
    }

    @Test
    public void setlog() throws Exception {

        LoggingRequest loggingRequest = new LoggingRequest();

        loggingRequest.setEmail("ayush@gmail.com");
        loggingRequest.setCalorie(100.0F);
        loggingRequest.setProtein(8F);
        loggingRequest.setFat(15F);
        loggingRequest.setCarbs(32F);
        loggingRequest.setDay(10);
        loggingRequest.setMonth(4);
        loggingRequest.setYear(2021);
        loggingRequest.setFoodName("Milk");
        loggingRequest.setQuantity(2F);

        Logging logging = new Logging();
        logging.setEmail("ayush@gmail.com");

        Mockito.when(loggingService.setlog(loggingRequest)).thenReturn(logging);

        Logging result = underTest.setlog(loggingRequest);

        Assertions.assertEquals(logging,result);
        Assertions.assertEquals("ayush@gmail.com",logging.getEmail());


    }



}