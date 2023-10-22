package baseball.controller;

import baseball.model.Computer;
import baseball.view.OutputView;

public class GameController {
    private final OutputView outputView;

    public GameController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printStart();
        Computer computer = new Computer();
    }
}
