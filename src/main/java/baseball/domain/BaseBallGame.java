package baseball.domain;

import static baseball.view.Input.*;

public class BaseBallGame {
    private final Computer computer;

    public BaseBallGame() {
        computer = new Computer();
    }

    public void play() {
        computer.makeAnswerNumber();
        gameStartMessage();
        inputNumber();
    }
}
