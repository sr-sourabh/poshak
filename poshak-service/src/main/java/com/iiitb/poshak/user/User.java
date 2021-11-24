package com.iiitb.poshak.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;

    @Field(name = "email_id")
    private String emailId;

    @Field(name = "password")
    private String password;

    @Field(name = "status")
    private int status;

    @Field(name = "name")
    private String name;

    @Field(name = "height")
    private int height;

    @Field(name = "weight")
    private int weight;

    @Field(name = "calorie_goal")
    private Float calorieGoal = 2000.0f;

    @Field(name = "fat_goal")
    private Float fatGoal = 30.0f;

    @Field(name = "carbs_goal")
    private Float carbsGoal = 250f;

    @Field(name = "protein_goal")
    private Float proteinGoal = 48f;

}

