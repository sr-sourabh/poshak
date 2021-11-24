package com.iiitb.poshak.trainer;

import com.iiitb.poshak.food.Food;
import com.iiitb.poshak.food.FoodRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@ExtendWith(MockitoExtension.class)
class TrainerServiceTest {
    @InjectMocks
    private TrainerService underTest;

    @Mock
    private TrainerGoalRepository trainerGoalRepository;

    @Mock
    private FoodRepository foodRepository;

    @Test
    public void setTrainerGoals() throws Exception {
        TrainerExcelRequest trainerExcelRequest =new TrainerExcelRequest();
        trainerExcelRequest.setTrainerEmail("trainer@gmail.com");
        ExcelFoodDto excelFoodDto =new ExcelFoodDto();
        excelFoodDto.setUserEmail("himanshu@gmail.com");
        excelFoodDto.setFoodName("milk");
        excelFoodDto.setTimeOfDay("11");
        excelFoodDto.setQuantity(1F);
        excelFoodDto.setDay("24");
        excelFoodDto.setMonth("11");
        excelFoodDto.setYear("2021");
        excelFoodDto.setCompleted(true);

        List<TrainerGoal> trainerGoals = new ArrayList<>();
        List<ExcelFoodDto> excelFoodDtos = new ArrayList<>();
        excelFoodDtos.add(excelFoodDto);
        trainerExcelRequest.setExcelFoods(excelFoodDtos);
        Food food = new Food();
        food.setFood("milk");
        food.setCalories("100");
        food.setCarbs("10");
        food.setFiber("14");
        List<Food> foods= new ArrayList<>();
        foods.add(food);

        TrainerGoal trainerGoal = new TrainerGoal();
        trainerGoal.setTrainerEmail(trainerExcelRequest.getTrainerEmail());
        trainerGoal.setFood(food);
        trainerGoal.setUserEmail(excelFoodDto.getUserEmail());
        trainerGoal.setTimeOfDay(excelFoodDto.getTimeOfDay());
        trainerGoal.setQuantity(excelFoodDto.getQuantity());
        Date date;
        String dateString = excelFoodDto.getDay() + "/" + excelFoodDto.getMonth() + "/" + excelFoodDto.getYear();
        date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        trainerGoal.setDate(date);
        trainerGoals.add(trainerGoal);

        Mockito.when(foodRepository.findByFoodIgnoreCase(excelFoodDto.getFoodName())).thenReturn(foods);
        Mockito.when(trainerGoalRepository.saveAll(trainerGoals)).thenReturn(trainerGoals);
        List<TrainerGoal> result = underTest.setTrainerGoals(trainerExcelRequest);

        Assertions.assertEquals(trainerGoals, result);
    }

    @Test
    public void getTrainerGoals() throws Exception {
        TrainerGetRequest trainerGetRequest = new TrainerGetRequest();
        trainerGetRequest.setUserEmail("himanshu@gmail.com");
        trainerGetRequest.setTrainerEmail("trainer@gmail.com");

        Set<TrainerGoal> trainerGoals = new HashSet<>();
        TrainerGoal trainerGoal1 = new TrainerGoal();
        trainerGoal1.setTrainerEmail("trainer@gmail.com");

        trainerGoals.add(trainerGoal1);

        Mockito.when(trainerGoalRepository.findAllByTrainerEmailAndUserEmail(trainerGetRequest.getTrainerEmail(),trainerGetRequest.getUserEmail())).thenReturn(trainerGoals);

        Set<TrainerGoal> result = underTest.getTrainerGoals(trainerGetRequest);

        Assertions.assertEquals(trainerGoals,result);
    }

    @Test
    public void getAllTrainerGoals() throws Exception {

        List<TrainerGoal> trainerGoals =  new ArrayList<>();
        TrainerGoal trainerGoal1 = new TrainerGoal();
        trainerGoal1.setTrainerEmail("trainer@gmail.com");

        TrainerGoal trainerGoal2 = new TrainerGoal();
        trainerGoal2.setTrainerEmail("trainer2@gmail.com");

        trainerGoals.add(trainerGoal2);
        trainerGoals.add(trainerGoal1);


        Mockito.when(trainerGoalRepository.findAll()).thenReturn(trainerGoals);

        Set<TrainerGoal> result = underTest.getAllTrainerGoals();
        List<TrainerGoal> finalResult = new ArrayList<>(result);
        Assertions.assertEquals(trainerGoals,finalResult);
    }
}