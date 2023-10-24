package baseball.controller;

import baseball.dto.GameNumber;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public static final String RETRY_COMMAND = "1";
    public static final String END_COMMAND = "2";

    public GameNumber getInputGameNumber() {
        return GameNumber.makeGameNumberByInput(Console.readLine());
    }

    public Boolean getIsRetry() {
        String input = Console.readLine();
        InputValidator.validateRetryInput(input);
        return input.equals(RETRY_COMMAND);
    }
}
