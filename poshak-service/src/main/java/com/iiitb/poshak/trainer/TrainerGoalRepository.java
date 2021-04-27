package com.iiitb.poshak.trainer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface TrainerGoalRepository extends MongoRepository<TrainerGoal, String> {

    Set<TrainerGoal> findAllByTrainerEmailAndUserEmail(String trainerEmail, String userEmail);

    @Query(value = "{ userEmail : ?0, trainerEmail : ?1, date : { $gt : ?2}, isCompleted : true }", count = true)
    Long countCompletedGoalsByUserEmailAndTrainerEmailAndDate(String userEmail, String trainerEmail, Date date);

    @Query(value = "{ userEmail : ?0, trainerEmail : ?1, date : { $gt : ?2} }", count = true)
    Long countTotalGoalsByUserEmailAndTrainerEmailAndDate(String userEmail, String trainerEmail, Date date);

    @Query(value = "{ trainerEmail : ?0, date : { $gt : ?1} }", count = true)
    Long countTotalGoalsByTrainerEmailAndDate(String trainerEmail, Date date);

    @Query(value = "{ trainerEmail : ?0, date : { $gt : ?1} }", count = true)
    Long countCompletedGoalsByTrainerEmailAndDate(String trainerEmail, Date date);

}


/*
1. Get number of foods completed by trainerEmail and userEmail
db.trainerGoal.aggregate([
   { $match: {trainerEmail : "trainer@trainer.com"} },
   { $group: { _id: '$userEmail', foodValue: { $sum: 1 } } }
])

 */