package baseball;

import java.util.Arrays;

public enum AfterGameStatus {
    RESTART("1"),
    EXIT("2");

    private final String value;

    AfterGameStatus(String value) {
        this.value = value;
    }

    public static AfterGameStatus from(String input) {

        return Arrays.stream(values())
                .filter(status -> status.value.equals(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isExitable() {
        return this == EXIT;
    }
}
