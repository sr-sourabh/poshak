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
    private Float fatValue = 0f;
    private Float carbsGoal;
    private Float carbsValue = 0f;
    private Float proteinGoal;
    private Float proteinValue = 0f;
    private Float calorieGoal;
    private Float calorieValue = 0f;
}
