package com.iiitb.poshak.kafka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KafkaModelTest {
    @Test
    public void test() {
        KafkaModel kafkaModel = new KafkaModel();
        kafkaModel.setUserEmail("22");
        kafkaModel.setFoodValue(22L);
        kafkaModel.setFoodGoal(22L);
        kafkaModel.set_id("22");

        Assertions.assertEquals("22", kafkaModel.getUserEmail());
        Assertions.assertEquals("22", kafkaModel.get_id());
        Assertions.assertEquals(22L, kafkaModel.getFoodGoal());
        Assertions.assertEquals(22L, kafkaModel.getFoodValue());
        Assertions.assertEquals(toString(kafkaModel), kafkaModel.toString());
        Assertions.assertEquals(hashCode(kafkaModel), kafkaModel.hashCode());
    }

    public int hashCode(KafkaModel kafkaModel) {
        int result = 1;
        Object $foodGoal = kafkaModel.getFoodGoal();
        result = result * 59 + ($foodGoal == null ? 43 : $foodGoal.hashCode());
        Object $foodValue = kafkaModel.getFoodValue();
        result = result * 59 + ($foodValue == null ? 43 : $foodValue.hashCode());
        Object $userEmail = kafkaModel.getUserEmail();
        result = result * 59 + ($userEmail == null ? 43 : $userEmail.hashCode());
        Object $_id = kafkaModel.get_id();
        result = result * 59 + ($_id == null ? 43 : $_id.hashCode());
        return result;
    }

    public String toString(KafkaModel kafkaModel) {
        return "KafkaModel(userEmail=" + kafkaModel.getUserEmail() + ", _id=" + kafkaModel.get_id() + ", foodGoal=" + kafkaModel.getFoodGoal() + ", foodValue=" + kafkaModel.getFoodValue() + ")";
    }
}