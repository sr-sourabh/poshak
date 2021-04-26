package com.iiitb.poshak.kafka;

import com.iiitb.poshak.logging.LoggingDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        kafkaModel.setFatGoal(100.0f);
        kafkaModel.setFatValue((float) value);

        kafkaTemplate.send(TOPIC, kafkaModel);

        return true;
    }

    public void postUserInfoToKafka(LoggingDto loggingDto) {
        KafkaModel kafkaModel = new KafkaModel();
        kafkaModel.setUserId(loggingDto.getUserId());
        kafkaModel.setUserName(loggingDto.getUserName());
        kafkaModel.setEmailId(loggingDto.getEmailId());

        kafkaModel.setCarbsValue(loggingDto.getCarbsGoal());
        kafkaModel.setFatValue(loggingDto.getFatValue());
        kafkaModel.setProteinValue(loggingDto.getProteinValue());
        kafkaModel.setCalorieValue(loggingDto.getCalorieValue());

        //kafka summary for 1 week
        kafkaModel.setCarbsGoal(loggingDto.getCarbsGoal());
        kafkaModel.setFatGoal(loggingDto.getFatGoal());
        kafkaModel.setProteinGoal(loggingDto.getProteinGoal());
        kafkaModel.setCalorieGoal(loggingDto.getCalorieGoal());

        kafkaTemplate.send(TOPIC, kafkaModel);
    }

}
