package baseball.domain;

import baseball.exception.ErrorMessage;
import baseball.exception.InvalidInputException;

import java.util.Arrays;

public enum Command {
    RETRY("1"),
    EXIT("2");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command fromValue(String value) {
        return Arrays.stream(Command.values())
                .filter(command -> command.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new InvalidInputException(ErrorMessage.INVALID_COMMAND));
    }

    public String getValue() {
        return value;
    }
}