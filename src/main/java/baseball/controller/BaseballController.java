package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballRestartOption;
import baseball.domain.BaseballResult;
import baseball.service.BaseballService;
import baseball.util.BaseballNumberConverter;
import baseball.util.BaseballRestartOptionConvertor;
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
        do {
            BaseballNumber computerNumber = baseballService.generateRandomNumbers();
            outputView.printGameStart();
            while (true) {
                BaseballNumber playerNumber = getPlayerInput();
                BaseballResult result = baseballService.calculateResult(computerNumber, playerNumber);
                outputView.printGameResult(result);

                if (isGameFinished(result)) {
                    outputView.printGameEnd();
                    break;
                }
            }
        } while (askRestart());
    }

    private BaseballNumber getPlayerInput() {
        String input = inputView.readPlayerNumbers();
        return BaseballNumberConverter.convert(input);
    }

    private boolean isGameFinished(BaseballResult result) {
        return result.toString().contains("3스트라이크");
    }

    private boolean askRestart() {
        String inputOption = inputView.readGameRestart();
        BaseballRestartOption restartOption = BaseballRestartOptionConvertor.convert(inputOption);
        return restartOption == BaseballRestartOption.RETRY;
    }
}
