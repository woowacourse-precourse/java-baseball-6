package controller;

import view.GameView;
import service.ComputerService;

public class ComputerController {
    private static ComputerController instance = new ComputerController();
    private static GameView gameView = GameView.getInstance();
    private static ComputerService computerService = ComputerService.getInstance();

    private ComputerController() { }

    public static ComputerController getInstance() {
        if (instance == null) {
            instance = new ComputerController();
        }
        return instance;
    }

    public void startGame() {
        computerService.startGame();
        gameView.startGame();
        gameView.guessNumber();
    }

    public void guessNumber(String guessingNum) {
        computerService.guessNumber(guessingNum);
    }
}
