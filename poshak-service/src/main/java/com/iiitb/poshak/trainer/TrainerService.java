package com.iiitb.poshak.trainer;

import com.iiitb.poshak.food.Food;
import com.iiitb.poshak.food.FoodRepository;
import com.iiitb.poshak.kafka.KafkaModel;
import com.iiitb.poshak.kafka.ProducerController;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
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

    @Resource
    private ProducerController producerController;

    @Transactional
    public List<TrainerGoal> setTrainerGoals(TrainerExcelRequest request) throws Exception {
        if (Strings.isBlank(request.getTrainerEmail())) {
            throw new Exception("Please provide trainer email");
        }

        List<TrainerGoal> trainerGoals = new ArrayList<>();

        request.getExcelFoods().forEach(excelFoodDto -> {
            TrainerGoal trainerGoal = new TrainerGoal();
            trainerGoal.setTrainerEmail(request.getTrainerEmail());
            List<Food> foods = foodRepository.findByFoodIgnoreCase(excelFoodDto.getFoodName());
            Food food = null;
            if (!CollectionUtils.isEmpty(foods)) {
                food = foods.get(0);
            }
            trainerGoal.setFood(food);
            trainerGoal.setUserEmail(excelFoodDto.getUserEmail());
            trainerGoal.setTimeOfDay(excelFoodDto.getTimeOfDay());
            trainerGoal.setQuantity(excelFoodDto.getQuantity());
            Date date;
            try {
                String dateString = excelFoodDto.getDay() + "/" + excelFoodDto.getMonth() + "/" + excelFoodDto.getYear();
                date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Unable to convert date" + e.getMessage());
            }
            trainerGoal.setDate(date);
            trainerGoals.add(trainerGoal);
        });

        return trainerGoalRepository.saveAll(trainerGoals);
    }

    @Transactional
    public Set<TrainerGoal> getTrainerGoals(TrainerGetRequest request) throws Exception {
        if (Strings.isBlank(request.getTrainerEmail()) || Strings.isBlank(request.getUserEmail())) {
            throw new Exception("Please send both trainer and user Emails");
        }
        return trainerGoalRepository.findAllByTrainerEmailAndUserEmail(request.getTrainerEmail(), request.getUserEmail());
    }

    @Transactional
    public TrainerGoal completeGoal(String goalId) throws Exception {
        if (Strings.isBlank(goalId)) {
            throw new Exception("Please provide goal id");
        }

        Optional<TrainerGoal> trainerGoalOptional = trainerGoalRepository.findById(goalId);
        if (!trainerGoalOptional.isPresent()) {
            throw new Exception("Trainer goal with id " + goalId + " not found");
        }

        TrainerGoal trainerGoal = trainerGoalOptional.get();
        trainerGoal.setCompleted(!trainerGoal.isCompleted());
        trainerGoal = trainerGoalRepository.save(trainerGoal);

        KafkaModel kafkaModel = new KafkaModel();
        kafkaModel.setUserEmail(trainerGoal.getUserEmail());
        Date date = getDate();

        kafkaModel.setFoodGoal(
                trainerGoalRepository.countTotalGoalsByUserEmailAndTrainerEmail(
                        trainerGoal.getUserEmail(),
                        trainerGoal.getTrainerEmail()));
        kafkaModel.setFoodValue(
                trainerGoalRepository.countCompletedGoalsByUserEmailAndTrainerEmail(
                        trainerGoal.getUserEmail(),
                        trainerGoal.getTrainerEmail()
                ));
        producerController.postUserInfoToKafka(kafkaModel);

        return trainerGoal;
    }

    @Transactional
    public Set<KafkaModel> getCompletedGoalsForTrainer(String trainerEmail) {

        AggregationResults<KafkaModel> results = trainerGoalRepository.countTrainerGoalsAndValue(trainerEmail);
        Set<KafkaModel> kafkaModels = new HashSet<>();
        results.getMappedResults().forEach(kafkaModel -> {
            kafkaModel.setUserEmail(kafkaModel.get_id());
            kafkaModels.add(kafkaModel);
        });
        return kafkaModels;
    }

    private Date getDate() {
        Date date = new Date();
        Long time = date.getTime();
        date = new Date(time - time % (24 * 60 * 60 * 1000));
        date = new Date(date.getTime() - 24 * 60 * 60 * 1000);
        return date;
    }
}
