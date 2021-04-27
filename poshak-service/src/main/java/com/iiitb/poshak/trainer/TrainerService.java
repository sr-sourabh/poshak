package com.iiitb.poshak.trainer;

import com.iiitb.poshak.food.Food;
import com.iiitb.poshak.food.FoodRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TrainerService {

    @Resource
    private TrainerGoalRepository trainerGoalRepository;

    @Resource
    private FoodRepository foodRepository;

    @Transactional
    public List<TrainerGoal> setTrainerGoals(TrainerExcelRequest request) throws Exception {
        if (Strings.isBlank(request.getTrainerEmail())) {
            throw new Exception("Please provide trainer email");
        }

        List<TrainerGoal> trainerGoals = new ArrayList<>();

        request.getExcelFoods().forEach(excelFoodDto -> {
            TrainerGoal trainerGoal = new TrainerGoal();
            trainerGoal.setTrainerEmail(request.getTrainerEmail());
            Food food = foodRepository.findByFoodIgnoreCase(excelFoodDto.getFoodName());
            trainerGoal.setFood(food);
            trainerGoal.setUserEmail(excelFoodDto.getUserEmail());
            trainerGoal.setTimeOfDay(excelFoodDto.getTimeOfDay());
            trainerGoal.setQuantity(excelFoodDto.getQuantity());
            Date date;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(excelFoodDto.getDate());
            } catch (ParseException e) {
                throw new IllegalArgumentException("Unable to convert date" + e.getMessage());
            }
            trainerGoal.setDate(date);
            trainerGoals.add(trainerGoal);
        });

        return trainerGoalRepository.saveAll(trainerGoals);
    }

    @Transactional
    public Set<TrainerGoal> getTrainerGoals(List<String> emails) throws Exception {
        if (CollectionUtils.isEmpty(emails) || emails.size() != 2) {
            throw new Exception("Please send both trainer and user Emails. Size of list should be 2");
        }
        return trainerGoalRepository.findAllByTrainerEmailAndUserEmail(emails.get(0), emails.get(1));
    }

    public TrainerGoal completeGoal(String goalId) throws Exception {
        if (Strings.isBlank(goalId)) {
            throw new Exception("Please provide goal id");
        }

        Optional<TrainerGoal> trainerGoalOptional = trainerGoalRepository.findById(goalId);
        if (!trainerGoalOptional.isPresent()) {
            throw new Exception("Trainer goal with id " + goalId + " not found");
        }

        TrainerGoal trainerGoal = trainerGoalOptional.get();
        trainerGoal.setCompleted(true);
        return trainerGoalRepository.save(trainerGoal);
    }
}
