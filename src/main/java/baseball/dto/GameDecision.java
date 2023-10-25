package baseball.dto;

import baseball.validator.InputValidator;

public class GameDecision {

    public static final String RETRY_COMMAND = "1";
    public static final String END_COMMAND = "2";

    private final String command;

    private GameDecision(String command) {
        this.command = command;
    }

    public static GameDecision makeGameDecisionByInput(String input) {
        InputValidator.validateInputGameDecision(input);
        return new GameDecision(input);
    }

    public Boolean isRetry() {
        return command.equals(RETRY_COMMAND);
    }
}
