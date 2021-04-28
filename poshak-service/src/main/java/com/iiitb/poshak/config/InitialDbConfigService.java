package com.iiitb.poshak.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiitb.poshak.food.FoodRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitialDbConfigService {

    @Resource
    private FoodRepository foodRepository;


    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void setupInitialFood() {
        long foodCount = foodRepository.count();
        System.out.println("Number of food items present: " + foodCount);
        if (foodCount == 0L) {
            System.out.println("Inserting food items");
            ObjectMapper mapper = new ObjectMapper();
            List<Food> foods = new ArrayList<>();
            // read JSON file and map/convert to java POJO
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new ClassPathResource("mongo/2.json").getInputStream());
                foods = mapper.readValue(inputStreamReader, FoodList.class);
                List<com.iiitb.poshak.food.Food> foodList = new ArrayList<>() ;
                foods.forEach(food -> {
                    com.iiitb.poshak.food.Food food1 = new com.iiitb.poshak.food.Food();
                    food1.setFood(food.getFood());
                    food1.setMeasure(food.getMeasure());
                    food1.setGrams(food.getGrams());
                    food1.setCalories(food.getCalories());
                    food1.setFat(food.getFat());
                    food1.setCarbs(food.getCarbs());
                    food1.setFiber(food.getFiber());
                    food1.setSatFat(food.getSatfat());
                    food1.setCategory(food.getCategory());
                    food1.setProtein(food.getProtein());

                    foodList.add(food1);
                });

                foodRepository.saveAll(foodList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
