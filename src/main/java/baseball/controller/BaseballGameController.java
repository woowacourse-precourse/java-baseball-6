package baseball.controller;

import baseball.domain.TargetNumber;
import baseball.domain.UserBaseballNumber;
import baseball.handler.InputHandler;
import baseball.handler.OutputHandler;
import baseball.service.BaseballGameService;

import java.util.Arrays;
import java.util.List;

public class BaseballGameController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final BaseballGameService baseballGameService;

    public BaseballGameController(InputHandler inputHandler, OutputHandler outputHandler, BaseballGameService baseballGameService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.baseballGameService = baseballGameService;
    }

    public void run() {
        outputHandler.printGameStart();

        TargetNumber targetNumber = new TargetNumber();

        while (true) {
            UserBaseballNumber userBaseballNumber = loadUserValues();

            playGame(targetNumber, userBaseballNumber);
        }
    }

    public UserBaseballNumber loadUserValues() {
        List<String> userValues = Arrays.asList(inputHandler.inputUserValue().split(""));

        return new UserBaseballNumber(userValues);
    }

    public void playGame(TargetNumber targetNumber, UserBaseballNumber userBaseballNumber) {

    }
}
