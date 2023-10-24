package baseball.controller;

import baseball.model.BallNumbers;
import baseball.model.Result;
import baseball.service.BallService;
import baseball.view.View;

public class GameController {
    private BallService ballService;
    private View view;

    public GameController(BallService ballService, View view) {
        this.ballService = ballService;
        this.view = view;
    }

    public void startGame() {
        view.showStartGame();
        do {
            playGame();
        } while (isRestart());
    }

    private void playGame() {
        BallNumbers computerBallNumbers = generateComputerBall();

        while (true) {
            String userNumberReadLine = view.inputUserNumber();
            BallNumbers userBallNumbers = ballService.initUserBallNumbers(userNumberReadLine);

            Result result = computerBallNumbers.compare(userBallNumbers);
            view.showGameResult(result.getResult());

            if (result.isEnd()) {
                view.showEnd();
                break;
            }
        }
    }

    private boolean isRestart() {
        String restart = view.inputGameRestart();
        return "1".equals(restart);
    }

    private BallNumbers generateComputerBall() {
        return ballService.generateRandomBallNumbers();
    }
}
