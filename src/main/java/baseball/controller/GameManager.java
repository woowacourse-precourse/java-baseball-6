package baseball.controller;

import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public GameManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.outputView.start();
        this.computer = new Computer();
    }

}
