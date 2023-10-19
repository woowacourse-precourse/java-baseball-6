package baseball.controller;

import baseball.view.OutputView;
public class BaseballGameController {
    OutputView outputView;

    public BaseballGameController() {
        this.outputView = new OutputView();
    }

    /*
    * 게임을 최초 시작하는 기능
    * */
    public void startGame() {
        outputView.readStartMessage();
    }
}
