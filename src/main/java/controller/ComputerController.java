package controller;

import view.GameView;
import service.ComputerService;

public class ComputerController {
    private static GameView gameView = new GameView();
    private static ComputerService computerService = ComputerService.getInstance();

    public void startGame() {
        computerService.startGame();
        gameView.startGame();
        gameView.guessNumber();
    }

    public void guessNumber(String numStr) {
        // TODO: validate

        // TODO: checkAnswer
    }
}
