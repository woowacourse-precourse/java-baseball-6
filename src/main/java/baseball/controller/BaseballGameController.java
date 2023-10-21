package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {
    BaseballGameService baseballGameService = new BaseballGameService();

    public void gameStart() {
        baseballGameService.startBaseballGame();
    }
}
