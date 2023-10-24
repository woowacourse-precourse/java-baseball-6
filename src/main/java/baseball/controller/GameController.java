package baseball.controller;

import baseball.model.GameModel;
import baseball.model.Result;
import baseball.model.Score;
import baseball.model.Value;
import baseball.view.GameView;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void playGame() {
        while (model.isExit()) {
            view.displayGameStartMessage();
            model.updateResult(new Result());
            playGameLoop();
        }
    }

    private void playGameLoop() {
        while (model.isGameRunning()) {
            try {
                Value value = model.processUserInput(view.getUserInput(), new Value());
                Score score = model.calculateScore(value);
                view.displayScore(score);

                if (model.isGameOver(score)) {
                    handleGameEnd();
                }
            } catch (IllegalArgumentException e) {
                view.displayErrorMessage(e.getMessage()); // 예외 메시지 출력
                throw e;
            }

        }
    }

    public void handleGameEnd() {
        view.displayGameOverMessage();
        if (view.askForReplay()) {
            model.resetGame();
        } else {
            model.endGame();
        }
    }
}
