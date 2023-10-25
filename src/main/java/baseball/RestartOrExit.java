package baseball;

import static baseball.constant.ErrorMessage.INVALID_RESTART_INPUT;

import java.util.Arrays;

public enum RestartOrExit {

    RESTART(1, true),
    EXIT(2, false);

    private final Integer inputValue;
    private final boolean isRestart;

    RestartOrExit(Integer inputValue, boolean isRestart) {
        this.inputValue = inputValue;
        this.isRestart = isRestart;
    }

    public static boolean isRestart(Integer userInput) {
        return Arrays.stream(RestartOrExit.values())
                .filter(value -> value.getInputValue() == userInput)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RESTART_INPUT))
                .isRestart();
    }

    public Integer getInputValue() {
        return inputValue;
    }

    public boolean isRestart() {
        return isRestart;
    }
}
