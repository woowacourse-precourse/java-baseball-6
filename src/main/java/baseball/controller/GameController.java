package baseball.controller;

import baseball.view.console.InputView;
import baseball.view.console.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    private void run() {
        outputView.gameStartMessage();
    }
}
