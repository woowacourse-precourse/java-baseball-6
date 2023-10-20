package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    public void startBaseballGame() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printGameStartMessage();
        String userNumber = inputView.getUserNumber();
    }
}
