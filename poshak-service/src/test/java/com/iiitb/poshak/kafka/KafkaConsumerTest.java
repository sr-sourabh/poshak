package com.iiitb.poshak.kafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class KafkaConsumerTest {
    @InjectMocks
    private KafkaConsumer kafkaConsumer;

    @Mock
    private SseEmitter sseEmitter;

    @Test
    public void processMessage() throws Exception {
        String message = "{\"userEmail\": \"email@email.com\"}";
        kafkaConsumer.processMessage(message);
    }

}