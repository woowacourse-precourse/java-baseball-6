package baseball;

import baseball.controller.GameController;
import baseball.domain.GameInfo;

/**
 * 게임을 제어하는 메인 클래스
 */
public class BaseballGame {
    private final GameController gameController = new GameController();

    public void run() {
        GameInfo gameInfo = new GameInfo();
        gameInfo.createRandomNumber(gameController.createRandomDistinctThreeDigit());
        while (gameInfo.getStrike() < 3) {
            String userInput = gameController.getUserInput();
            gameController.countStrikeAndBall(gameInfo, userInput);
            gameController.printResultMessageForInput(gameInfo.getBall(), gameInfo.getStrike());
        }
        gameController.controlRestartOrExit();
    }

    public void startGame() {
        gameController.startGame();
    }
}
