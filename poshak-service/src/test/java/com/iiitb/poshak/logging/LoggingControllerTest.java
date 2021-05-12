package com.iiitb.poshak.logging;

import com.iiitb.poshak.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sun.util.logging.resources.logging;

@ExtendWith(MockitoExtension.class)
class LoggingControllerTest {
    @InjectMocks
    private LoggingController underTest;

    @Mock
    private LoggingService loggingService;

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
        Assertions.assertEquals("ayush@gmail.com","ayush@gmail.com");


    }
}