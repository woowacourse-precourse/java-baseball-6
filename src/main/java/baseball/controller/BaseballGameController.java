package baseball.controller;

import baseball.servcie.BaseballGameService;

public class BaseballGameController {

    private BaseballGameService baseballGameService;

    public BaseballGameController() {
        this.baseballGameService = new BaseballGameService();
    }

    public void startGame(){
        baseballGameService.playGame();
    }

    public boolean checkRestartGame(){
        return baseballGameService.checkRestart();
    }
}
