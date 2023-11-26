package baseball.service;

import baseball.domain.Coachs;
import baseball.domain.FoodManager;
import baseball.domain.MenuResult;
import baseball.domain.ProhibitedFood;

import java.util.List;

public class LunchService {
    private final Coachs coachs;

    public LunchService(List<String> inputNames) {
        this.coachs = new Coachs(inputNames);
    }

    public CoachsDTO createCoachsDTO() {
        return new CoachsDTO(coachs);
    }

    public List<String> getCoachNames() {
        return coachs.getCoachNames();
    }

    public void addProhibitedFood(String coachName, List<String> prohibitedFoods) {
        coachs.findCoachByName(coachName).addProhibitedFood(new ProhibitedFood(prohibitedFoods));
    }

    public MenuResult recommendFoodMenus() {
        FoodManager foodManager = new FoodManager();
        return foodManager.reportFoodMenus(coachs);
    }
}
