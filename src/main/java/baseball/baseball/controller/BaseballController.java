package baseball.baseball.controller;

import baseball.baseball.model.BaseballService;

import java.util.List;

public class BaseballController {
    private static final BaseballService baseballService = new BaseballService();
    private static List<Integer> goalNumber;

    public void run(){
        start();
    }

    private static void start(){
        goalNumber = baseballService.createGoalNumber();
    }
}
