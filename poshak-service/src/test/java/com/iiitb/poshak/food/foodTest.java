package com.iiitb.poshak.food;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class foodTest {

    @InjectMocks
    private Food underTest;

    @Test
    public void food(){

        Food food = new Food();
        food.setId("100");
        food.setFood("apple");
        food.setMeasure("gm");
        food.setGrams("150");
        food.setCalories("189");
        food.setProtein("39");
        food.setFat("24");
        food.setSatFat("67");
        food.setFiber("19");
        food.setCarbs("57");
        food.setCategory("milk product");

        Assertions.assertEquals("100",food.getId());
        Assertions.assertEquals("apple",food.getFood());
        Assertions.assertEquals("gm",food.getMeasure());
        Assertions.assertEquals("150",food.getGrams());
        Assertions.assertEquals("189",food.getCalories());
        Assertions.assertEquals("39",food.getProtein());
        Assertions.assertEquals("24",food.getFat());
        Assertions.assertEquals("67",food.getSatFat());
        Assertions.assertEquals("19",food.getFiber());
        Assertions.assertEquals("57",food.getCarbs());
        Assertions.assertEquals("milk product",food.getCategory());


        String foodString  = "Food(id=" + food.getId() + ", food=" + food.getFood() + ", measure=" + food.getMeasure() + ", " +
                "grams=" + food.getGrams() + ", calories=" + food.getCalories() + ", protein=" + food.getProtein() + "," +
                " fat=" + food.getFat() + ", satFat=" + food.getSatFat() + ", fiber=" + food.getFiber() + ", carbs=" +
                food.getCarbs() + ", category=" + food.getCategory() + ")";

        Assertions.assertEquals(foodString,food.toString());
        Assertions.assertEquals(hashCode(food),food.hashCode());

    }


    public int hashCode(Food food) {
        int result = 1;
        Object $id = food.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $food = food.getFood();
        result = result * 59 + ($food == null ? 43 : $food.hashCode());
        Object $measure = food.getMeasure();
        result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
        Object $grams = food.getGrams();
        result = result * 59 + ($grams == null ? 43 : $grams.hashCode());
        Object $calories = food.getCalories();
        result = result * 59 + ($calories == null ? 43 : $calories.hashCode());
        Object $protein = food.getProtein();
        result = result * 59 + ($protein == null ? 43 : $protein.hashCode());
        Object $fat = food.getFat();
        result = result * 59 + ($fat == null ? 43 : $fat.hashCode());
        Object $satFat = food.getSatFat();
        result = result * 59 + ($satFat == null ? 43 : $satFat.hashCode());
        Object $fiber = food.getFiber();
        result = result * 59 + ($fiber == null ? 43 : $fiber.hashCode());
        Object $carbs = food.getCarbs();
        result = result * 59 + ($carbs == null ? 43 : $carbs.hashCode());
        Object $category = food.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        return result;
    }
}
