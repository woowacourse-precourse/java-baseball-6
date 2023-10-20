package baseball.controller;

import baseball.domain.UserBaseballNumber;
import baseball.handler.InputHandler;

public class BaseballGameController {

    private final InputHandler inputHandler;

    public BaseballGameController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        inputHandler.inputUserValue();
    }
}
