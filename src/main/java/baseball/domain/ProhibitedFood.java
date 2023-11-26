package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class ProhibitedFood {
    private final List<String> prohibitedFoods = new ArrayList<>();

    public ProhibitedFood(List<String> prohibitedFoodNames) {
        if (!isValidFoodNumber(prohibitedFoodNames)) {
            throw new IllegalArgumentException("[ERROR] 최소 0개에서 최대 2개만 입력가능 합니다.");
        }
        for (String prohibitedFoodName : prohibitedFoodNames) {
            if (prohibitedFoodName.isEmpty()) {
                return;
            }
            checkValidation(prohibitedFoodName);
            prohibitedFoods.add(prohibitedFoodName);
        }
    }

    private static boolean isValidFoodNumber(List<String> prohibitedFoodNames) {
        return prohibitedFoodNames.size() >= 0 || prohibitedFoodNames.size() < 3;
    }

    private void checkValidation(String prohibitedFoodName) {
        if (!FoodCategory.contain(prohibitedFoodName)) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다.");
        }
    }

    public boolean isEmpty() {
        return prohibitedFoods.isEmpty();
    }

    public boolean contains(String food) {
        return prohibitedFoods.contains(food);
    }
}

