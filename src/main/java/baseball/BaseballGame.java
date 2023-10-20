package baseball;

import baseball.controller.GameController;
import baseball.domain.GameInfo;
import baseball.service.GameService;

public class BaseballGame {

    private final GameController gameController = new GameController();
    private final GameService gameService = new GameService();

    public void run() {
        GameInfo gameInfo = new GameInfo();
        gameInfo.createRandomNumber(gameService.generateRandomDistinctThreeDigit());
        while (gameInfo.getStrike() < 3) {
            String userInput = gameController.getUserInput();
            gameService.countStrikeOrBall(gameInfo, userInput);
            gameController.checkStrikeOrBall(gameInfo.getBall(), gameInfo.getStrike());
        }
    }
}
