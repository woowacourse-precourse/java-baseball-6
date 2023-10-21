package baseball.controller;

import baseball.domain.GameChoice;
import baseball.domain.GameResult;
import baseball.domain.TargetNumber;
import baseball.domain.UserBaseballNumber;
import baseball.handler.InputHandler;
import baseball.handler.OutputHandler;
import baseball.service.BaseballGameService;

import java.util.Arrays;
import java.util.List;

public class BaseballGameController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final BaseballGameService baseballGameService;

    public BaseballGameController(InputHandler inputHandler, OutputHandler outputHandler, BaseballGameService baseballGameService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.baseballGameService = baseballGameService;
    }

    public void run() {
        outputHandler.printGameStart();

        GameChoice gameChoice = new GameChoice();

        TargetNumber targetNumber = new TargetNumber();

        while (gameChoice.isRestart()) {
            playGame(targetNumber);
        }
    }

    public UserBaseballNumber loadUserValues() {
        List<String> userValues = Arrays.asList(inputHandler.inputUserValue().split(""));

        return new UserBaseballNumber(userValues);
    }

    public void playGame(TargetNumber targetNumber) {
        while (true) {
            UserBaseballNumber userBaseballNumber = loadUserValues();
            GameResult gameResult = baseballGameService.compareNumber(targetNumber, userBaseballNumber);
            outputHandler.printGameResult(gameResult.getResult());

            if (gameResult.isWin()) {
                break;
            }
        }
    }

    public void requestGameChoice() {

    }
}
