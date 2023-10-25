package baseball.controller;

import baseball.view.OutputView;

public class GameController {
    private final OutputView outputView;

    public GameController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printStart();
    }
}
