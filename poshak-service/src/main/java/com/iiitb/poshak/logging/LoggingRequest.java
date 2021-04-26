package com.iiitb.poshak.logging;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoggingRequest {
    private String id;
    private String email;
    private int calorie;
    private int protein;
    private int fat;
    private int carbs;
    private int day;
    private int month;
    private int year;
}









