package baseball.model;

import java.util.Objects;
import java.util.stream.Stream;

public enum RestartOption {
    RESTART("1"),
    QUIT("2");


    private static final String WRONG_INPUT = "[ERROR] 잘못된 입력입니다.";
    private final String command;

    RestartOption(String command) {
        this.command = command;
    }

    public static RestartOption from(String command) {
        return Stream.of(values())
                .filter(option -> Objects.equals(option.command, command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_INPUT));
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
