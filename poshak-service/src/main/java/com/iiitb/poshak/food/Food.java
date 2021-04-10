package com.iiitb.poshak.food;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "food")
@Data
@NoArgsConstructor
public class Food {
    @Id
    private String id;

    @Field(name = "Food")
    private String food;

    @Field(name = "Measure")
    private String measure;

    @Field(name = "Grams")
    private String grams;

    @Field(name = "Calories")
    private String calories;

    @Field(name = "Protein")
    private String protein;

    @Field(name = "Fat")
    private String fat;

    @Field(name = "Sat.Fat")
    private String satFat;

    @Field(name = "Fiber")
    private String fiber;

    @Field(name = "Carbs")
    private String carbs;

    @Field(name = "Category")
    private String category;
}
