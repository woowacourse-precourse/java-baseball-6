package baseball.controller;

import baseball.model.domain.Computer;
import baseball.view.OutputView;

public class NumberBaseball {
    private final Computer computer;

    public NumberBaseball() {
        computer = new Computer();
    }

    public void start() {
        OutputView.printGameStart();
    }
}
