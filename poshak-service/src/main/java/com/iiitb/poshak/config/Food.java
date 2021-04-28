package com.iiitb.poshak.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Food {
    private String food;
    private String measure;
    private String grams;
    private String calories;
    private String protein;
    private String fat;
    private String satfat;
    private String fiber;
    private String carbs;
    private String category;
}
