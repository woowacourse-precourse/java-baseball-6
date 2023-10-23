package baseball.domain;

import baseball.exception.ErrorMessage;

import java.util.Arrays;

public enum RestartCommand {
    RESTART("1"),
    EXIT("2"),
    ;

    private final String symbol;

    RestartCommand(String symbol) {
        this.symbol = symbol;
    }

    public static boolean isExit(String message) {
        validateCommand(message);
        return message.equals(EXIT.symbol);
    }

    private static void validateCommand(String message) {
        boolean isValid = Arrays.stream(RestartCommand.values())
                .map(restartCommand -> restartCommand.symbol)
                .toList()
                .contains(message);

        if (!isValid) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
