package baseball.controller;

import baseball.model.BaseballGame;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private BaseballGame baseballGame;
    private BaseballGameView baseballGameView;

    public BaseballGameController() {
        baseballGame = new BaseballGame();
        baseballGameView = new BaseballGameView();
    }

    public int startGame() {
        int randomNumber = baseballGame.makeRandomNumber();
        baseballGameView.startView();


        return 1;
    }




}
