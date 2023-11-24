package baseball.model;

import java.util.Arrays;

public enum GameStatus {

    RESTART("1"),
    QUIT("2");

    private static final String INVALID_COMMAND_EX_MESSAGE = "재시작(1) 또는 종료(2)가 아닙니다.";

    private final String command;

    GameStatus(String command) {
        this.command = command;
    }

    public static GameStatus find(String command) {
        return Arrays.stream(values())
                .filter(status -> status.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_EX_MESSAGE));
    }
}
