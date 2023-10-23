package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.Result;
import baseball.service.BallService;
import baseball.view.GameView;

public class GameController {
    private BaseballNumber computerNumber;
    private BaseballNumber userNumber;
    private BallService ballService = new BallService();
    private GameView gameView = new GameView();

    public void startGame() {
        do {
            gameView.showGameStart();
            playGame();
        } while (isRestart());
    }

    public void playGame() {
        generateComputerNumber();

        while (true) {
            String userNumberReadLine = gameView.getUserNumber();
            userNumber = ballService.initUserNumber(userNumberReadLine);

            Result result = computerNumber.compare(userNumber);
            gameView.showGameResult(result);

            if (result.isEnd()) {
                gameView.showEnd();
                break;
            }
        }
    }

    private boolean isRestart() {
        String restart = gameView.inputGameRestart();
        return "1".equals(restart);
    }

    private void generateComputerNumber() {
        computerNumber = ballService.generateRandomNum();
    }
}
