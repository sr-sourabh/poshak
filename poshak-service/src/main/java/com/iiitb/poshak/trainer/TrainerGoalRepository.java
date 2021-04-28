package com.iiitb.poshak.trainer;

import com.iiitb.poshak.kafka.KafkaModel;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TrainerGoalRepository extends MongoRepository<TrainerGoal, String> {

    Set<TrainerGoal> findAllByTrainerEmailAndUserEmail(String trainerEmail, String userEmail);

    @Query(value = "{ userEmail : ?0, trainerEmail : ?1, isCompleted : true }", count = true)
    Long countCompletedGoalsByUserEmailAndTrainerEmail(String userEmail, String trainerEmail);

    @Query(value = "{ userEmail : ?0, trainerEmail : ?1 }", count = true)
    Long countTotalGoalsByUserEmailAndTrainerEmail(String userEmail, String trainerEmail);

    @Aggregation(pipeline = {
            "{ $match: {trainerEmail : ?0} }",
            "{ $group: { _id: '$userEmail', foodValue: { $sum: { $cond : ['$isCompleted', 1, 0]} }, foodGoal : {$sum : 1} } }"
    })
    AggregationResults<KafkaModel> countTrainerGoalsAndValue(String trainerEmail);

}


/*
1. Get number of foods completed by trainerEmail and userEmail
db.trainerGoal.aggregate([
   { $match: {trainerEmail : "trainer@trainer.com"} },
   { $group: { _id: '$userEmail', foodValue: { $sum: { $cond : ['$isCompleted', 1, 0]} }, foodGoal : {$sum : 1} } }
])

 */