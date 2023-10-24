package baseball.controller;

import baseball.model.GameStatus;
import baseball.service.BaseballGameService;
import baseball.service.BaseballGameValidateService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final BaseballGameService baseballGameService = new BaseballGameService();
    private final BaseballGameValidateService baseballGameValidateService = new BaseballGameValidateService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private static final int GAME_END_STRIKE_COUNT = 3;

    public void playGame() {
        initGame();
        printBaseballGameStartMessage();
        inputNumber();
        retryOrEnd();
    }

    private void initGame() {
        baseballGameService.initGame();
    }

    private void printBaseballGameStartMessage() {
        outputView.printBaseballGameStartMessage();
    }

    private void inputNumber() {
        while (baseballGameService.getStrikeCount() != GAME_END_STRIKE_COUNT) {
            outputView.printInputNumberMessage();
            String inputNumber = inputView.inputNumber();
            baseballGameValidateService.validateInputNumber(inputNumber);
            String countMessage = baseballGameService.resolveBallOrStrikeCount(inputNumber);
            outputView.printCountMessage(countMessage);
        }
    }

    private void retryOrEnd() {
        inputRetryOrEndCommandProcess();
        if (baseballGameService.getGameStatus().equals(GameStatus.START)) {
            retryProcess();
        }
    }

    private void retryProcess() {
        baseballGameService.initGame();
        inputNumber();
        retryOrEnd();
    }

    private void inputRetryOrEndCommandProcess() {
        outputView.printRetryOrEndMessageProcess();
        String inputRetryOrEndCommand = inputView.inputRetryOrEndCommand();
        baseballGameValidateService.validateGameRetryOrEndCommand(inputRetryOrEndCommand);
        baseballGameService.changeGameStatusByCommand(inputRetryOrEndCommand);
    }
}
