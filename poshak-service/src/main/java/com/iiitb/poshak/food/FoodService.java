package com.iiitb.poshak.food;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodService {
    @Resource
    private FoodRepository foodRepository;

    public List<Food> getAllFoodByName(String name) {
        return foodRepository.findAllByFoodContainingIgnoreCase(name.toLowerCase());
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
}
