package com.iiitb.poshak.trainer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TrainerGoalRepository extends MongoRepository<TrainerGoal, String> {

    Set<TrainerGoal> findAllByTrainerEmailAndUserEmail(String trainerEmail, String userEmail);

}
