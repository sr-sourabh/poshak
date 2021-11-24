package com.iiitb.poshak.trainer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class TrainerControllerTest {
    @InjectMocks
    private TrainerController underTest;

    @Mock
    private TrainerService trainerService;

    @Test
    public void setTrainerGoals() throws Exception {

        TrainerExcelRequest trainerExcelRequest = new TrainerExcelRequest();
        ExcelFoodDto excelFoodDto = new ExcelFoodDto();
        excelFoodDto.setUserEmail("ayush@gmail.com");
        excelFoodDto.setFoodName("banana");
        excelFoodDto.setTimeOfDay("10");
        excelFoodDto.setQuantity(1F);
        excelFoodDto.setDay("1");
        excelFoodDto.setMonth("5");
        excelFoodDto.setYear("2021");
        excelFoodDto.setCompleted(true);

        List<ExcelFoodDto> excelFoodDtos = new ArrayList<>();
        excelFoodDtos.add(excelFoodDto);

        trainerExcelRequest.setTrainerEmail("trainer@gmail.com");
        trainerExcelRequest.setExcelFoods(excelFoodDtos);

        List<TrainerGoal> trainerGoals = new ArrayList<>();

        TrainerGoal trainerGoal = new TrainerGoal();
        trainerGoal.setCompleted(true);

        trainerGoals.add(trainerGoal);

        Mockito.when(trainerService.setTrainerGoals(trainerExcelRequest)).thenReturn(trainerGoals);

        List<TrainerGoal> result = underTest.setTrainerGoals(trainerExcelRequest);

        Assertions.assertEquals(trainerGoals, result);


    }

    @Test
    public void getAllTrainerGoals() throws Exception {

        Set<TrainerGoal> trainerGoals = new HashSet<>();

        TrainerGoal trainerGoal = new TrainerGoal();
        trainerGoal.setTrainerEmail("trainer@gmail.com");

        trainerGoals.add(trainerGoal);

        Mockito.when(trainerService.getAllTrainerGoals()).thenReturn(trainerGoals);

        Set<TrainerGoal> result = underTest.getAllTrainerGoals();

        Assertions.assertEquals(trainerGoals, result);

    }

    @Test
    public void completeGoal() throws Exception {
        String goalId;
        goalId = "235645443";

        TrainerGoal trainerGoal = new TrainerGoal();
        trainerGoal.setCompleted(true);

        Mockito.when(trainerService.completeGoal(goalId)).thenReturn(trainerGoal);

        TrainerGoal result = underTest.completeGoal(goalId);

        Assertions.assertEquals(trainerGoal, result);
    }


    @Test
    public void getTrainerGoals() throws Exception {

        TrainerGetRequest trainerGetRequest = new TrainerGetRequest();
        trainerGetRequest.setTrainerEmail("trainer@gmail.com");
        trainerGetRequest.setUserEmail("ayush@gmail.com");

        Set<TrainerGoal> trainerGoals = new HashSet<>();
        TrainerGoal trainerGoal = new TrainerGoal();
        trainerGoal.setTrainerEmail("trainer@gmail.com");

        trainerGoals.add(trainerGoal);

        Mockito.when(trainerService.getTrainerGoals(trainerGetRequest)).thenReturn(trainerGoals);

        Set<TrainerGoal> result = underTest.getTrainerGoals(trainerGetRequest);

        Assertions.assertEquals(trainerGoals, result);


    }


}
