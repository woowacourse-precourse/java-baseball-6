package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        outputView.printStartGame();
    }
}
