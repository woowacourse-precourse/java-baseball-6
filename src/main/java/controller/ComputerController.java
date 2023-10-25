package controller;

import dto.GuessResultDto;
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
        while (computerService.isComputerGaming()) {
            gameView.guessNumber();
        }
    }

    public void restartGame() {
        computerService.startGame();
        while (computerService.isComputerGaming()) {
            gameView.guessNumber();
        }
    }

    public void endGame() {
        computerService.endGame();
    }

    public void guessNumber(String guessingNum) {
        GuessResultDto guessResultDto = computerService.guessNumber(guessingNum);
        gameView.guessResult(guessResultDto);
    }
}
