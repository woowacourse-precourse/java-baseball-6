package baseball;

import java.util.Arrays;

public enum RestartStatus {
    RESTART(1),
    EXIT(2);

    private final int number;

    RestartStatus(int number) {
        this.number = number;
    }

    public static RestartStatus getStatus(int number) {
        return Arrays.stream(RestartStatus.values())
                .filter(status -> status.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.IS_NOT_RESTART_NUMBER.toString()));
    }
}
