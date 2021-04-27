package com.iiitb.poshak.trainer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TrainerExcelRequest {
    private String trainerEmail;
    private List<ExcelFoodDto> excelFoods;

}
