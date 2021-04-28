package com.iiitb.poshak.kafka;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KafkaModel {
    private String userEmail;
    private String _id;
    private Long foodGoal;
    private Long foodValue;
}
