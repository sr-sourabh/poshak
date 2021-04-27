package com.iiitb.poshak.trainer;

import com.iiitb.poshak.food.Food;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "trainerGoal")
public class TrainerGoal {

    @Id
    private String id;

    @Field(name = "trainerEmail")
    private String trainerEmail;

    @Field(name = "userEmail")
    private String userEmail;

    @Field(name = "food")
    private Food food;

    @Field(name = "timeOfDay")
    private String timeOfDay;

    @Field(name = "quantity")
    private Float quantity;

    @Field(name = "date")
    private Date date;

    @Field(name = "isCompleted")
    private boolean isCompleted = false;

}
