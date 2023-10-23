package baseball.controller;

import baseball.servcie.BaseballGameService;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private final BaseballGameService baseballGameService;
    private final BaseballGameView baseballGameView;

    public BaseballGameController(BaseballGameService baseballGameService, BaseballGameView baseballGameView) {
        this.baseballGameService = baseballGameService;
        this.baseballGameView = baseballGameView;
    }

    public void startGame(){
        baseballGameView.startGamePrint();
        baseballGameService.playGame();
    }

    public boolean checkRestartGame(){
        baseballGameView.endGamePrint();
        return baseballGameService.checkRestart();
    }
}
