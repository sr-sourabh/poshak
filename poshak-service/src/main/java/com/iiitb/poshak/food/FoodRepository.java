package com.iiitb.poshak.food;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends MongoRepository<Food, String> {
    List<Food> findAllByFoodContainingIgnoreCase(String name);

    List<Food> findAll();

    List<Food> findByFoodIgnoreCase(String foodName);
}
