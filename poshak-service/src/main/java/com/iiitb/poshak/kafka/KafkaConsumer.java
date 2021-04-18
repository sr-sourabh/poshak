package com.iiitb.poshak.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
public class KafkaConsumer {

    private SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);

    @Value("${com.iiitb.poshak.kafka.topic}")
    private String TOPIC;

    @KafkaListener(topics = "${com.iiitb.poshak.kafka.topic}")
    public void processMessage(String message) throws IOException {
        System.out.printf("%s \n", message);
        KafkaModel kafkaModel = new ObjectMapper().readValue(message, KafkaModel.class);
        sendToClient(kafkaModel);
    }

    @GetMapping("/kafka/live")
    @CrossOrigin
    public SseEmitter sendToClient(KafkaModel kafkaModel) {

        try {
            sseEmitter.send(SseEmitter.event().name(TOPIC).data(kafkaModel, MediaType.APPLICATION_JSON));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            sseEmitter = new SseEmitter(Long.MAX_VALUE);
        }
        return sseEmitter;
    }

}
