package baseball;

import baseball.controller.GameController;
import baseball.domain.GameInfo;

public class BaseballGame {
    private final GameController gameController = new GameController();

    public void run() {
        GameInfo gameInfo = new GameInfo();
        gameInfo.createRandomNumber(gameController.generateRandomDistinctThreeDigit());
        while (gameInfo.getStrike() < 3) {
            String userInput = gameController.getUserInput();
            gameController.countStrikeOrBall(gameInfo, userInput);
            gameController.checkStrikeOrBall(gameInfo.getBall(), gameInfo.getStrike());
        }
        gameController.controlRestartOrExit();
    }
}
