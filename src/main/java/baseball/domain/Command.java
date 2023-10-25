package baseball.domain;

import static baseball.utils.ErrorMessages.NOT_INVALID_RETRY_INPUT;

import java.util.Arrays;

public enum Command {
    RETRY("1"),
    QUIT("2"),
    ;

    private final String value;

    private Command(String value) {
        this.value = value;
    }

    public static Command of(String value) {
        return Arrays.stream(values())
                .filter(command -> command.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_INVALID_RETRY_INPUT));
    }

    public Boolean isRetry() {
        return RETRY.equals(this);
    }
}
