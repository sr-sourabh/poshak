package com.iiitb.poshak.logging;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
public class Log {

    @Field(name = "id")
    private String id;

    @Field(name = "calorie")
    private int calorie;

    @Field(name = "protein")
    private int protein;

    @Field(name = "fat")
    private int fat;

    @Field(name = "carbs")
    private int carbs;

    @Field(name = "day")
    private int day;

    @Field(name = "month")
    private int month;

    @Field(name = "year")
    private int year;


//    'Calories': 360.0,
//            'Protein': 36,
//            'Fat': 0,
//            'Sat.Fat': 0.0,
//            'Fiber': 0.0,
//            'Carbs': 52.0,
}
