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
    private Float calorie;

    @Field(name = "protein")
    private Float protein;

    @Field(name = "fat")
    private Float fat;

    @Field(name = "carbs")
    private Float carbs;

    @Field(name = "date")
    private Long date;
}
