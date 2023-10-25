package baseball.dto;

import baseball.validator.InputValidator;

public class GameDecision {

    public static final String RETRY_COMMAND = "1";
    public static final String END_COMMAND = "2";

    private final String command;

    public GameDecision(String input) {
        InputValidator.validateInputGameDecision(input);
        this.command = input;
    }

    public Boolean isRetry() {
        return command.equals(RETRY_COMMAND);
    }
}
