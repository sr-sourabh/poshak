package com.iiitb.poshak.logging;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoggingDto {
    private String emailId;
    private String userId;
    private String userName;
    private Float fatGoal;
    private Float fatValue;
    private Float carbsGoal;
    private Float carbsValue;
    private Float proteinGoal;
    private Float proteinValue;
    private Float calorieGoal;
    private Float calorieValue;
}
