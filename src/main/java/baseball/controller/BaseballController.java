package baseball.controller;

import baseball.dto.ResultDto;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController() {
        this.baseballService = new BaseballService();
    }

    public void run() {
        OutputView.printStart();

        do {
            baseballService.init();
            do {
                playGame();
                printGameResult();
            } while (!baseballService.isGameOver());
        } while (isRetry());
    }

    private Boolean isRetry() {
        OutputView.printGameOver();
        String command = InputView.inputRetryOrQuit();
        return baseballService.isRetry(command);
    }

    private void playGame() {
        String number = InputView.inputNumber();
        baseballService.playGame(number);
    }

    private void printGameResult() {
        ResultDto gameResult = baseballService.getGameResult();
        OutputView.printBaseballResult(gameResult);
    }
}
