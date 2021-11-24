package com.iiitb.poshak.food;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class foodTest {

    @InjectMocks
    private Food underTest;

    @Test
    public void food(){

        Food food = new Food();
        food.setId("100");
        food.setFood("apple");
        food.setMeasure("gm");
        food.setGrams("150");
        food.setCalories("189");
        food.setProtein("39");
        food.setFat("24");
        food.setSatFat("67");
        food.setFiber("19");
        food.setCarbs("57");
        food.setCategory("milk product");

        Assertions.assertEquals("100",food.getId());
        Assertions.assertEquals("apple",food.getFood());
        Assertions.assertEquals("gm",food.getMeasure());
        Assertions.assertEquals("150",food.getGrams());
        Assertions.assertEquals("189",food.getCalories());
        Assertions.assertEquals("39",food.getProtein());
        Assertions.assertEquals("24",food.getFat());
        Assertions.assertEquals("67",food.getSatFat());
        Assertions.assertEquals("19",food.getFiber());
        Assertions.assertEquals("57",food.getCarbs());
        Assertions.assertEquals("milk product",food.getCategory());

    }
}
