package baseball.controller;

import baseball.service.GameService;

public class GameController {

    private GameService gameService;

    public GameController() {
        gameService = new GameService();
        gameInit();
    }

    private void gameInit() {
        gameService.init();
    }
}
