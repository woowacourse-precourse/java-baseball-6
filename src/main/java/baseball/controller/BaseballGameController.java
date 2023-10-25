package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {
    BaseballGameService baseballGameService = new BaseballGameService();
    final int GAME_FLAG = 0;
    public void gameStart() {
        baseballGameService.startBaseballGame(GAME_FLAG);
    }
}
