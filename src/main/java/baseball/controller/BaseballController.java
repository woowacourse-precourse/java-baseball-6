package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;
import baseball.service.BaseballService;
import baseball.util.BaseballNumberConverter;
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

        while (true) {
            BaseballNumber playerNumber = getPlayerInput();
            BaseballResult result = baseballService.calculateResult(computerNumber, playerNumber);
        }
    }

    private BaseballNumber getPlayerInput() {
        String input = inputView.readPlayerNumbers();
        return BaseballNumberConverter.convert(input);
    }
}
