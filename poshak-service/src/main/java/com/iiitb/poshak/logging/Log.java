package com.iiitb.poshak.logging;

import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Field(name = "date")
    private Long date;
}
