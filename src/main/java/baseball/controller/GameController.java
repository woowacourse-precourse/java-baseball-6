package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startGame() {
        outputView.printStartMessage();
        String playerNumberStr = inputView.inputPlayerNumber();
    }
}
