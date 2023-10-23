package baseball.controller;

import baseball.model.BaseballNumber;
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

    public void playGame() {
        BaseballNumber computerNumber = generateComputerNumber();

        while (true) {
            String userNumberReadLine = view.inputUserNumber();
            BaseballNumber userNumber = ballService.initUserNumber(userNumberReadLine);

            Result result = computerNumber.compare(userNumber);
            view.showGameResult(result);

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

    private BaseballNumber generateComputerNumber() {
        return ballService.generateRandomNum();
    }
}
