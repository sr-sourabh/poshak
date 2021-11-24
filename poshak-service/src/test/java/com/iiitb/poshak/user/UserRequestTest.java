package com.iiitb.poshak.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserRequestTest {
    @Test
    public void getRequest() {
        UserRequest request = new UserRequest();
        request.setEmailId("33");
        request.setPassword("33");
        request.setName("33");
        request.setStatus(33);
        request.setHeight(33);
        request.setWeight(33);
        request.setCalorieGoal(33f);
        request.setFatGoal(33f);
        request.setCarbsGoal(33f);
        request.setProteinGoal(33f);

        Assertions.assertEquals("33", request.getEmailId());
        Assertions.assertEquals("33", request.getPassword());
        Assertions.assertEquals("33", request.getName());
        Assertions.assertEquals(33, request.getStatus());
        Assertions.assertEquals(33, request.getHeight());
        Assertions.assertEquals(33, request.getWeight());
        Assertions.assertEquals(33f, request.getCalorieGoal());
        Assertions.assertEquals(33f, request.getFatGoal());
        Assertions.assertEquals(33f, request.getCarbsGoal());
        Assertions.assertEquals(33f, request.getProteinGoal());
        Assertions.assertEquals(toString(request), request.toString());
        Assertions.assertEquals(hashCode(request), request.hashCode());

    }

    public int hashCode(UserRequest user) {
        int result = 1;
        Object $status = user.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $height = user.getHeight();
        result = result * 59 + ($height == null ? 43 : $height.hashCode());
        Object $weight = user.getWeight();
        result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
        Object $calorieGoal = user.getCalorieGoal();
        result = result * 59 + ($calorieGoal == null ? 43 : $calorieGoal.hashCode());
        Object $fatGoal = user.getFatGoal();
        result = result * 59 + ($fatGoal == null ? 43 : $fatGoal.hashCode());
        Object $carbsGoal = user.getCarbsGoal();
        result = result * 59 + ($carbsGoal == null ? 43 : $carbsGoal.hashCode());
        Object $proteinGoal = user.getProteinGoal();
        result = result * 59 + ($proteinGoal == null ? 43 : $proteinGoal.hashCode());
        Object $emailId = user.getEmailId();
        result = result * 59 + ($emailId == null ? 43 : $emailId.hashCode());
        Object $password = user.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Object $name = user.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString(UserRequest user) {
        return "UserRequest(emailId=" + user.getEmailId() + ", password=" + user.getPassword() + ", name=" + user.getName() + ", status=" + user.getStatus() + ", height=" + user.getHeight() + ", weight=" + user.getWeight() + ", calorieGoal=" + user.getCalorieGoal() + ", fatGoal=" + user.getFatGoal() + ", carbsGoal=" + user.getCarbsGoal() + ", proteinGoal=" + user.getProteinGoal() + ")";
    }
}