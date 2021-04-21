package com.iiitb.poshak.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
    private String emailId;
    private String password;
    private String name;
    private Integer status;
    private Integer height;
    private Integer weight;
    private Float calorieGoal;
    private Float fatGoal;
    private Float carbsGoal;
    private Float proteinGoal;
}
