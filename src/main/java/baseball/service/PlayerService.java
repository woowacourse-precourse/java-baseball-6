package baseball.service;

import baseball.domain.Ball;
import baseball.view.Input;

public class PlayerService {
    Input input = new Input();

    public Ball inputPlayerNumber() {
        return input.inputNumber();
    }
}
