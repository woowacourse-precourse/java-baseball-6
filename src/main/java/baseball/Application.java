package baseball;


import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LunchService lunchService = new LunchService();
        CoachsDTO coachsDTO = takeInputName(lunchService);

        for (String name : coachsDTO.getNames()) {
            reportProhibitedFood(name, lunchService);
        }
        OutputView.printMenu(lunchService.recommendFoods());
    }

    private static CoachsDTO takeInputName(LunchService lunchService) {
        try {
            return lunchService.createCoachsDTO(InputView.readCoachName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeInputName(lunchService);
        }
    }

    private static void reportProhibitedFood(String name, LunchService lunchService) {
        try {
            lunchService.putProhibitedFoods(InputView.readProhibitedFood(name));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            reportProhibitedFood(name, lunchService);
        }
    }
}