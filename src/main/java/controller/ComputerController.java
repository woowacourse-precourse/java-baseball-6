package controller;

import view.GameView;

public class ComputerController {
    private static GameView gameView = new GameView();

    public void startGame() {
        gameView.startGame();
        gameView.guessNumber();
    }

    public void guessNumber(String numStr) {
        // TODO: validate

        // TODO: checkAnswer
    }
}
