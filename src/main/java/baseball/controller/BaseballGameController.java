package baseball.controller;

import baseball.domain.User;
import baseball.servcie.BaseballGameService;

public class BaseballGameController {

    private final BaseballGameService baseballGameService;

    public BaseballGameController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void startGame(){
        baseballGameService.playGame();
    }

    public boolean checkRestartGame(){
        return baseballGameService.checkRestart();
    }
}
