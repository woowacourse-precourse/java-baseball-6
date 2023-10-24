package baseball.controller;

import baseball.service.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        playGame();
    }

    private void setGame() {
        gameService.setGame();
    }

    private void playGame() {
        gameService.playGame();
    }
}