package com.iiitb.poshak.food;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FoodControllerTest {
    @InjectMocks
    private FoodController underTest;

    @Mock
    private FoodService foodService;

<<<<<<<<< Temporary merge branch 1
=========

>>>>>>>>> Temporary merge branch 2
    @Test

    public void getAllFoodByFoodName() throws Exception {

        String foodname;
        foodname = "milk";

<<<<<<<<< Temporary merge branch 1
        Food food = new Food();
=========
        Food food =new Food();
>>>>>>>>> Temporary merge branch 2
        food.setFood("milk");
        food.setCalories("100");
        food.setCarbs("10");
        food.setFiber("14");

        List<Food> foods= new ArrayList<>();
        foods.add(food);

        Mockito.when(foodService.getAllFoodByName(foodname)).thenReturn(foods);

        List<Food> result = underTest.getAllFoodByName(foodname);

        Assertions.assertEquals(foods,result);

    }

    @Test
    public void getAllFood() throws Exception {


        Food food =new Food();
        food.setFood("milk");
        food.setCalories("100");
        food.setCarbs("10");
        food.setFiber("14");

        List<Food> foods= new ArrayList<>();
        foods.add(food);

        Mockito.when(foodService.getAllFood()).thenReturn(foods);

        List<Food> result = underTest.getAllFood();

        Assertions.assertEquals(foods,result);

    }








}

>>>>>>>>> Temporary merge branch 2
