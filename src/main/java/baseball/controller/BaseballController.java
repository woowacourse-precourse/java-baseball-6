package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController() {
        this.baseballService = new BaseballService();
    }

    public void playGame() {
        BaseballNumber computerNumber = baseballService.generateRandomNumbers();
    }

}
