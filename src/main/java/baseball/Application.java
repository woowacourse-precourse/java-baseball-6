package baseball;


import baseball.domain.MenuResult;
import baseball.service.LunchService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView.printIntro();
        LunchService lunchService = createLunchService();

        for (String coachName : lunchService.getCoachNames()) {
            List<String> prohibitedFoods = takeProhibitedFood(coachName);
            lunchService.addProhibitedFood(coachName, prohibitedFoods);
        }

        MenuResult menuResult = lunchService.recommendFoodMenus();
        OutputView.printResult(menuResult);
    }

    private static LunchService createLunchService() {
        try {
            return new LunchService(InputView.takeInputNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLunchService();
        }
    }

    private static List<String> takeProhibitedFood(String coachName) {
        try {
             return InputView.takeInputProhibitedFood(coachName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeProhibitedFood(coachName);
        }
    }
}