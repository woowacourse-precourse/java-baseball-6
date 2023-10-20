package baseball.controller;

import baseball.service.GameService;

public class GameController {
    private static GameController gameController;

    private final GameService gameService;

    public static GameController getInstance() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }

    private GameController() {
        gameService = GameService.getInstance();
    }
}
