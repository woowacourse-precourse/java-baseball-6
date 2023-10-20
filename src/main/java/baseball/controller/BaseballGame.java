package baseball.controller;

import baseball.model.Computer;
import baseball.view.OutputView;

public class BaseballGame {
    private Computer computer;

    public void startGame() {
        OutputView.startGameMessage();
        createComputerNumber();
    }

    private void createComputerNumber() {
        computer = new Computer();
    }
}
