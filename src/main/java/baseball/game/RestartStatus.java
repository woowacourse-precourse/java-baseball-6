package baseball.game;

import java.util.Arrays;

public enum RestartStatus {
    RESTART("재시작", "1"),
    END("종료", "2");

    private final String description;
    private final String inputValue;

    RestartStatus(String description, String inputValue) {
        this.description = description;
        this.inputValue = inputValue;
    }

    public static boolean gonnaRestart(String inputValue) {
        return getRestartStatusFromInputValue(inputValue) == RESTART;
    }

    private static RestartStatus getRestartStatusFromInputValue(String inputValue) {
       return Arrays.stream(values())
                .filter(restartStatus -> restartStatus.inputValue
                        .equals(inputValue))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 못한 재시작 입력값입니다"));
    }

}
