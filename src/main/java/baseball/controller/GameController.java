package baseball.controller;

import baseball.service.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
    }

    private void setGame() {
        gameService.setGame();
    }
}