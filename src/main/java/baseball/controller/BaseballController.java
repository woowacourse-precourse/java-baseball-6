package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;
import baseball.view.InputView;

public class BaseballController {
    private final BaseballService baseballService;
    private final InputView inputView;

    public BaseballController() {
        this.baseballService = new BaseballService();
        this.inputView = new InputView();
    }

    public void playGame() {
        BaseballNumber computerNumber = baseballService.generateRandomNumbers();
    }

}
