package com.iiitb.poshak.kafka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

@ExtendWith(MockitoExtension.class)
class ProducerControllerTest {

    @InjectMocks
    private ProducerController producerController;

    @Mock
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

    @Test
    public void testPost() {
        Integer value = 22;
        Boolean result = producerController.post(value);
        Assertions.assertEquals(true, result);
    }
}