package baseball.controller;

import baseball.domain.UserBaseballNumber;
import baseball.handler.InputHandler;
import baseball.handler.OutputHandler;

import java.util.Arrays;
import java.util.List;

public class BaseballGameController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public BaseballGameController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        outputHandler.printGameStart();

        UserBaseballNumber userBaseballNumber = loadUserValues();
    }

    public UserBaseballNumber loadUserValues() {
        List<String> userValues = Arrays.asList(inputHandler.inputUserValue().split(""));

        return new UserBaseballNumber(userValues);
    }
}
