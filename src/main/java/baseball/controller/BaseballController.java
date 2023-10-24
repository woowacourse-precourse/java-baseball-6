package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;
import baseball.service.BaseballService;
import baseball.util.BaseballNumberConverter;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final BaseballService baseballService;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController() {
        this.baseballService = new BaseballService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void playGame() {
        BaseballNumber computerNumber = baseballService.generateRandomNumbers();
        outputView.printGameStart();
        while (true) {
            BaseballNumber playerNumber = getPlayerInput();
            BaseballResult result = baseballService.calculateResult(computerNumber, playerNumber);
            outputView.printGameResult(result);
        }
    }

    private BaseballNumber getPlayerInput() {
        String input = inputView.readPlayerNumbers();
        return BaseballNumberConverter.convert(input);
    }
}
