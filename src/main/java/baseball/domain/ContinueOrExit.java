package baseball.domain;

import java.util.Arrays;

public enum ContinueOrExit {
    CONTINUE("1"),
    EXIT("2");

    private static final String CONTINUE_OR_EXIT_NUMBER_EXCEPTION_MESSAGE = "입력값은 1 또는 2 만 가능합니다.";
    private final String value;

    ContinueOrExit(String value) {
        this.value = value;
    }

    public static ContinueOrExit from(String input) {
        return Arrays.stream(values())
                .filter(continueOrExit -> continueOrExit.value.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(CONTINUE_OR_EXIT_NUMBER_EXCEPTION_MESSAGE));
    }

    public boolean isContinue() {
        return this == CONTINUE;
    }
}
