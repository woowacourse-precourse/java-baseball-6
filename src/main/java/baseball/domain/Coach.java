package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private final CoachName name;
    private ProhibitedFood prohibitedFoods;
    private final List<String> recommendedFoods = new ArrayList<>();

    public Coach(String name) {
        this.name = new CoachName(name);
    }

    public void addProhibitedFood(ProhibitedFood prohibitedFoods) {
        this.prohibitedFoods = prohibitedFoods;
    }

    public void addRecommendedFood(FoodCategory foodCategory) {
        String food = null;
        boolean isContain = true;
        while (isContain) {
            food = recommendFood(foodCategory);
            isContain = recommendedFoods.contains(food) || prohibitedFoods.contains(food);
        }
        recommendedFoods.add(food);
    }

    private String recommendFood(FoodCategory foodCategory) {
        return foodCategory.recommendFood();
    }

    public boolean hasName(String coachName) {
        return name.equals(new CoachName(coachName));
    }

    public List<String> getRecommendedFoods() {
        return Collections.unmodifiableList(recommendedFoods);
    }

    public String getName() {
        return name.getName();
    }
}
