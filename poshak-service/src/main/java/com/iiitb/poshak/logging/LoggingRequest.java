package com.iiitb.poshak.logging;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LoggingRequest {

    private String email;
    //    private List<Log> log;
    private int calorie;
    private int protein;
    private int fat;
    private int carbs;
//    private Data date;
}









