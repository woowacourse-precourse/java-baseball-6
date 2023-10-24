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
            Value value = model.processUserInput(view.getUserInput(), new Value());
            Score score = model.calculateScore(value);
            view.displayScore(score);

            if (model.isGameOver(score)) {
                handleGameEnd();
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
