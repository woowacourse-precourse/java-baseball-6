package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startBaseballGame() {
        outputView.printStartGameMessage();
    }
}