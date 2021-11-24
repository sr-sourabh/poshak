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
class FoodServiceTest {
    @InjectMocks
    private FoodService underTest;

    @Mock
    private FoodRepository foodRepository;

    @Test
    public void getAllFoodByName(){
        String foodname;
        foodname = "milk";

        Food food = new Food();
        food.setFood("milk");
        food.setCalories("100");
        food.setCarbs("10");
        food.setFiber("14");

        List<Food> foods= new ArrayList<>();
        foods.add(food);

        Mockito.when(foodRepository.findAllByFoodContainingIgnoreCase(foodname)).thenReturn(foods);

        List<Food> result = underTest.getAllFoodByName(foodname);

        Assertions.assertEquals(foods,result);
    }

    @Test
    public void getAllFood(){
        Food food = new Food();
        List<Food> foods= new ArrayList<>();
        foods.add(food);

        Mockito.when(foodRepository.findAll()).thenReturn(foods);

        List<Food> result = underTest.getAllFood();

        Assertions.assertEquals(foods,result);
    }
}