package com.iiitb.poshak.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProducerController {

    @Resource
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

    @Value("${com.iiitb.poshak.kafka.topic}")
    private String TOPIC;

    public boolean post(KafkaModel kafkaModel) {

        kafkaTemplate.send(TOPIC, kafkaModel);

        return true;
    }

}
