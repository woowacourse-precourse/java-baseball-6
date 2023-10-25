package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {
    private final BaseballGameService baseballGameService;

    public BaseballGameController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void playBaseballGame() {
        baseballGameService.playBaseballGame();
    }
}
