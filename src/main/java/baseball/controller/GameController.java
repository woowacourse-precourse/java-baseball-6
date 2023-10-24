package baseball.controller;

import baseball.service.GameService;

public class GameController {

    private GameService gameService = new GameService();

    public void play() {
        gameService.startGame();
    }
}
