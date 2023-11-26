package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodManager {
    private int MONDAY = 0;
    private int FRIDAY = 4;
    private final List<FoodCategory> foodCategories = new ArrayList<>();

    public MenuResult reportFoodMenus(Coachs coachs) {
        for (int i = MONDAY; i <= FRIDAY; i++) {
            FoodCategory category = drawFoodCategory();
            recommendFoodForCoachs(category, coachs);
        }
        return new MenuResult(coachs, foodCategories);
    }

    private FoodCategory drawFoodCategory() {
        FoodCategory category = null;
        boolean isContain = true;
        while (isContain) {
            category = FoodCategory.getCategory(Randoms.pickNumberInRange(1, 5));
            isContain = Collections.frequency(foodCategories, category) >= 2;
        }
        foodCategories.add(category);
        return category;
    }

    private void recommendFoodForCoachs(FoodCategory category, Coachs coachs) {
        for (Coach coach : coachs.getCoachs()) {
            coach.addRecommendedFood(category);
        }
    }

    public List<FoodCategory> getFoodCategories() {
        return foodCategories;
    }
}
