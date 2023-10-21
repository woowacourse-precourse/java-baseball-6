package baseball.model;

import java.util.Arrays;

public enum Command {

    RESTART("1"),
    EXIT("2");

    private static final String INVALID_COMMAND_EXCEPTION = "1(재시작) 또는 2(종료) 명령만 가능합니다.";

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command find(String value) {
        return Arrays.stream(values())
                .filter(command -> command.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_EXCEPTION));
    }
}
