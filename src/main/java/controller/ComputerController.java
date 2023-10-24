package controller;

import view.GameView;

public class ComputerController {
    private static GameView gameView = new GameView();

    public void startGame() {
        gameView.startGame();
    }
}
