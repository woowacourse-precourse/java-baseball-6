package baseball;

import baseball.controller.GameController;
import baseball.domain.GameInfo;
import baseball.validation.InputValidation;

public class BaseballGame {
    private final InputValidation inputValidation = new InputValidation();
    private final GameController gameController = new GameController();

    public void run() {
        GameInfo gameInfo = new GameInfo();
        gameInfo.createRandomNumber(gameController.generateRandomDistinctThreeDigit());
        while (gameInfo.getStrike() < 3) {
            String userInput = gameController.getUserInput();
            inputValidation.validateInputNum(userInput);
            gameController.countStrikeOrBall(gameInfo, userInput);
            gameController.checkStrikeOrBall(gameInfo.getBall(), gameInfo.getStrike());
        }
        gameController.controlRestartOrExit();
    }
}
