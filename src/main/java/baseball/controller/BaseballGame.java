package baseball.controller;

import baseball.domain.Computer;
import baseball.view.OutputView;

public class BaseballGame {

    private final OutputView outputView;
    private final Computer computer;

    public BaseballGame(OutputView outputView, Computer computer) {
        this.outputView = outputView;
        this.computer = computer;
    }

    public void start() {
        outputView.printStartMessage();

        do {
            play();
        } while (isContinue());
    }

    private void play() {
        computer.generateNumbers();
    }

    private boolean isContinue() {
        return false;
    }
}
