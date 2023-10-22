package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.Validation;

public class BaseballGameController {

    private int ball;
    private int strike;
    private Computer computer;
    private User user;
    private Validation validation;
    private final int MAX_LENGTH = 3;

    public BaseballGameController() {
        this.computer = new Computer();
        this.validation = new Validation();
        this.computer.makeNumber();
    }

    public void initGame() {
        this.ball = 0;
        this.strike = 0;
        this.user = new User();
    }
}
