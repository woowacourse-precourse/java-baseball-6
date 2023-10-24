package baseball.controller;

import baseball.service.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        playGame();
        endGame();
        retryGame();
    }

    private void setGame() {
        gameService.setGame();
    }

    private void playGame() {
        gameService.playGame();
    }

    private void endGame() {
        gameService.endGame();
    }

    private void retryGame() {
        if(gameService.retryGame() == 1){
            run();
        }
    }
}