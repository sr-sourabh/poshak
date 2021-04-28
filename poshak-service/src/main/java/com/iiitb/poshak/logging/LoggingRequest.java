package com.iiitb.poshak.logging;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoggingRequest {
    private String id;
    private String email;
    private Float calorie;
    private Float protein;
    private Float fat;
    private Float carbs;
    private int day;
    private int month;
    private int year;
    private String foodName;
    private Float quantity;
}









