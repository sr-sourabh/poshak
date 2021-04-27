package com.iiitb.poshak.trainer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExcelFoodDto {
    private String userEmail;
    private String foodName;
    private String timeOfDay;
    private Float quantity = 1f;
    private String date;
}
