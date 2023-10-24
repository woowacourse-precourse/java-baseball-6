package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {
    private BaseballGameService baseballGameService;

    public BaseballGameController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void start() {
        do {
            baseballGameService.settingGame();
            baseballGameService.start();
        } while (baseballGameService.isRestart());

    }
}
