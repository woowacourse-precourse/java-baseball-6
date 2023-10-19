package baseball.domain;

import static baseball.view.Input.*;

public class BaseBallGame {
    private final Computer computer;
    private final User user;

    public BaseBallGame() {
        computer = new Computer();
        user = new User();
    }

    public void play() {
        computer.makeAnswerNumber();
        gameStartMessage();
        user.setUserNumber(inputNumber());
    }
}
