package com.iiitb.poshak.trainer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.iiitb.poshak.kafka.KafkaModel;
import com.iiitb.poshak.util.ErrorDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
public class TrainerController {

    private static final Logger log = LogManager.getLogger(TrainerController.class);

    @Resource
    private TrainerService trainerService;

    @ExceptionHandler(Exception.class)
    public ErrorDto handleException(Exception e) {
        e.printStackTrace();
        ErrorDto errorDto = new ErrorDto();
        errorDto.getError().add(e.getMessage());
        errorDto.setExceptionId("IE-" + System.currentTimeMillis());
        return errorDto;
    }

    @PutMapping(value = "/trainer")
    public List<TrainerGoal> setTrainerGoals(@RequestBody TrainerExcelRequest request) throws Exception {
        log.info("excel target request: {}", request);
        return trainerService.setTrainerGoals(request);
    }

    @PutMapping(value = "/trainer/get")
    public Set<TrainerGoal> getTrainerGoals(@RequestBody TrainerGetRequest request) throws Exception {
        //0 element is trainerEmail, 1st element is userEmail
        log.info("Set goal request: {}", request);
        return trainerService.getTrainerGoals(request);
    }

    @PutMapping(value = "/trainer/complete/{goalId}")
    public TrainerGoal completeGoal(@PathVariable("goalId") String goalId) throws Exception {
        log.info("Complete goal: {}", goalId);
        return trainerService.completeGoal(goalId);
    }

    //for kafka only
    @GetMapping(value = "/trainer/{trainerEmail}")
    public Set<KafkaModel> getCompletedGoalsForTrainer(@PathVariable("trainerEmail") String trainerEmail) throws Exception {
        log.info("get completed goal for trainer: {}", trainerEmail);

        return trainerService.getCompletedGoalsForTrainer(trainerEmail);
    }

    @GetMapping(value = "/trainer/all")
    public Set<TrainerGoal> getAllTrainerGoals(){
        return trainerService.getAllTrainerGoals();
    }

}
