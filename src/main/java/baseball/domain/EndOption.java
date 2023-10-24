package baseball.domain;

import java.util.Arrays;

public enum EndOption {

    RESTART(1),
    END(2),
    ;

    private final int value;

    EndOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isContain(int value) {
        return Arrays.stream(values())
                .map(EndOption::getValue)
                .anyMatch(option -> option == value);
    }
}
