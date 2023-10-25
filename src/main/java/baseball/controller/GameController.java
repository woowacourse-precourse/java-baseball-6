package baseball.controller;

import baseball.service.BaseballService;

public class GameController {
    public BaseballService baseballService = new BaseballService();
    public void Init() {
        baseballService.startNewGame();
    }

}
