package baseball;

import java.util.Arrays;

public enum GameCommand {
    RESTART("1"),
    EXIT("2");

    private static final String ERROR_MESSAGE = "%s는 재시작/종료 입력 값이 아닙니다.";
    private final String value;

    GameCommand(final String value) {
        this.value = value;
    }

    public static GameCommand from(final String value) {
        return Arrays.stream(values())
                .filter(gameCommand -> gameCommand.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, value)));
    }
}
