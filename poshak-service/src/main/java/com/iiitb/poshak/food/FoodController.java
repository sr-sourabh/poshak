package com.iiitb.poshak.food;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FoodController {

    private static final Logger log = LogManager.getLogger(FoodController.class);

    @Resource
    private FoodService foodService;

    @GetMapping(value = "/foodByName/{foodName}")
    public List<Food> getAllFoodByName(@PathVariable("foodName") String foodName) {
        log.info("Get food by name Request: {} ", foodName);
        return foodService.getAllFoodByName(foodName);
    }

    @GetMapping(value = "/food/all")
    public List<Food> getAllFood() {
        log.info("Get all food request");
        return foodService.getAllFood();
    }
}
