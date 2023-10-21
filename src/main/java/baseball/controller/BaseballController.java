package baseball.controller;

import baseball.io.OutputView;

public class BaseballController {

    private final OutputView outputView;

    public BaseballController(final OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
    }
}
