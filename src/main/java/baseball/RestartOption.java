package baseball;

import java.util.Arrays;

public enum RestartOption {
    RESTART("1", true),
    EXIT("2", false);
    private final String optionCode;
    private final boolean isRestart;

    RestartOption(String optionCode, boolean isRestart) {
        this.optionCode = optionCode;
        this.isRestart = isRestart;
    }

    public static boolean isRestart(String optionCode) {
        return Arrays.stream(values())
                .filter(option -> option.optionCode.equals(optionCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Message.INVALID_RESTART_OPTION.getMessage()))
                .isRestart;
    }
}
