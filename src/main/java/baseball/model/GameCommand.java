package baseball.model;

import java.util.Arrays;

public enum GameCommand {

    RESTART("1"),
    QUIT("2");

    private static final String WRONG_INPUT_MESSAGE = "1또는 2를 입력해주세요";

    private final String number;

    GameCommand(final String number) {
        this.number = number;
    }

    public static GameCommand make(final String input) {
        return Arrays.stream(values())
                .filter(command -> command.number.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_INPUT_MESSAGE));
    }

    public static boolean isRestart(final GameCommand command) {
        return command.equals(RESTART);
    }
}
