package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseBallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        inputView.readUserNumber();
    }
}
