package com.iiitb.poshak.logging;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Log {
    private Long id;
    private Float calorie;
    private Float protein;
    private Float fat;
    private Float carbs;
    private Long date;
    private String foodName;
    private Float quantity;
}
