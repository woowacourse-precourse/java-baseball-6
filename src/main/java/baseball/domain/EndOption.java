package baseball.domain;

import static baseball.domain.ErrorCode.INVALID_OPTION_NUMBER;

import baseball.exception.InvalidArgumentException;
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

    public static boolean isEnd(int value) {
        return valueOf(value) == END;
    }

    private static EndOption valueOf(int value) {
        return Arrays.stream(values())
            .filter(option -> option.getValue() == value)
            .findFirst()
            .orElseThrow(() -> new InvalidArgumentException(INVALID_OPTION_NUMBER));
    }
}
