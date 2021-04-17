package com.iiitb.poshak.kafka;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KafkaModel {
    private String food;
    private String measure;
    private String grams;
    private String calories;
    private String protein;
    private String fat;
    private String satFat;
    private String fiber;
    private String carbs;
    private String category;
}
