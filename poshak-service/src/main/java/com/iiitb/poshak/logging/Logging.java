package com.iiitb.poshak.logging;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "logging")
public class Logging {

    @Id
    private String id;

    @Field(name = "email_id")
    private String email;

    @Field(name = "log")
    private List<Log> log;


//            'Calories': 360.0,
//            'Protein': 36,
//            'Fat': 0,
//            'Sat.Fat': 0.0,
//            'Fiber': 0.0,
//            'Carbs': 52.0,


//    {
//        'Quantity' : 2,
//        'Food': 'Milk skim', 'Measure': '1 qt.',
//            'Grams': 984,
//            'Calories': 360.0,
//            'Protein': 36,
//            'Fat': 0,
//            'Sat.Fat': 0.0,
//            'Fiber': 0.0,
//            'Carbs': 52.0,
//            'Category': 'Dairy products'
//    }
}
