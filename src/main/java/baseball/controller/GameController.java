package baseball.controller;

import baseball.service.GameService;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void play() {
        gameService.startGame();
    }
}
