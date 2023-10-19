package baseball.controller;

import baseball.view.OutputView;

public class BaseballController {
    final OutputView outputView;

    public BaseballController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
    }
}
