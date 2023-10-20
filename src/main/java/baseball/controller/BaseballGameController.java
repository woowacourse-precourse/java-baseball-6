package baseball.controller;

import baseball.domain.UserBaseballNumber;
import baseball.handler.InputHandler;

import java.util.Arrays;
import java.util.List;

public class BaseballGameController {

    private final InputHandler inputHandler;

    public BaseballGameController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        UserBaseballNumber userBaseballNumber = loadUserValues();
    }

    public UserBaseballNumber loadUserValues() {
        List<String> userValues = Arrays.asList(inputHandler.inputUserValue().split(""));

        return new UserBaseballNumber(userValues);
    }
}
