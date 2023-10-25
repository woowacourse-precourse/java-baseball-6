package baseball.service;

import baseball.domain.ThreeNumbers;
import baseball.view.Input;

public class PlayerService {
    Input input = new Input();

    public ThreeNumbers inputPlayerNumber() {
        return input.inputNumber();
    }

    public boolean inputOneOrTwo() {
        return input.inputOneOrTwo();
    }
}
