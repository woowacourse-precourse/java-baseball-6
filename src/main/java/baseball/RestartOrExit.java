package baseball;

import java.util.Arrays;

public enum RestartOrExit {

    RESTART(1, true),
    EXIT(2, false);

    private final Integer inputValue;
    private final boolean isRestart;

    private final static String ERR_INVALID_RESTART_INPUT = "1과 2중에 입력해야합니다.";

    RestartOrExit(Integer inputValue, boolean isRestart) {
        this.inputValue = inputValue;
        this.isRestart = isRestart;
    }

    public static boolean isRestart(Integer userInput) {
        return Arrays.stream(RestartOrExit.values())
                .filter(value -> value.getInputValue() == userInput)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_RESTART_INPUT))
                .isRestart();
    }

    public Integer getInputValue() {
        return inputValue;
    }

    public boolean isRestart() {
        return isRestart;
    }
}
