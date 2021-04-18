package com.iiitb.poshak.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@RestController
public class ProducerController {

    @Resource
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

    @Value("${com.iiitb.poshak.kafka.topic}")
    private String TOPIC;

    @GetMapping("/kafka/{value}")
    public boolean post(@PathVariable("value") Integer value) {

        KafkaModel kafkaModel = new KafkaModel();
        kafkaModel.setTarget(100);
        kafkaModel.setValue(value);

        kafkaTemplate.send(TOPIC, kafkaModel);

        return true;
    }

}
