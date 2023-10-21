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
        int userInput = baseballGameView.readUserInputView();

        // 사용자 입력값 예외처리 작성

        return 1;
    }




}
