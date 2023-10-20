package baseball.controller;

import baseball.view.OutputView;

public class BaseballGameController {
    public void startBaseballGame() {
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();
    }
}
