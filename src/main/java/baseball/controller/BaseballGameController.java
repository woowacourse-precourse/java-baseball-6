package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {
    private final BaseballGameService gameService;

    public BaseballGameController() {
        this.gameService = new BaseballGameService();
    }
    public void start() {
        gameService.startGame();
    }
}
