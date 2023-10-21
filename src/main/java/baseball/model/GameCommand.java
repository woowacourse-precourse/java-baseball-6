package baseball.model;

import java.util.Arrays;

public enum GameCommand {

    RESTART("1"),
    QUIT("2");

    private static final String WRONG_INPUT = "잘못된 입력입니다.";

    private final String number;

    GameCommand(String number) {
        this.number = number;
    }

    public static GameCommand make(final String input) {
        return Arrays.stream(values())
            .filter(command -> command.number.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(WRONG_INPUT));
    }
}
