package baseball.service;

import baseball.view.Input;

public class Player {
    Input input = new Input();
    public String inputPlayerNumber() {
        return input.inputNumber();
    }
}
