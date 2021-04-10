package com.iiitb.poshak.food;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FoodController {
    @Resource
    private FoodService foodService;

    @GetMapping(value = "/foodByName/{foodName}")
    public List<Food> getAllFoodByName(@PathVariable("foodName") String foodName) {
        return foodService.getAllFoodByName(foodName);
    }

    @GetMapping(value = "/food/all")
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }
}
