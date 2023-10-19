package baseball.controller;

import baseball.view.OutputView;

public class BaseballController {
    OutputView outputView = new OutputView();
    public void baseballGame(){
        startGame();
    }
    private void startGame(){
        outputView.printGameStart();
    }
}
