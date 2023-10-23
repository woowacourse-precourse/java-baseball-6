package baseball.model;

import java.util.Arrays;

public enum GameCommand {

    RESTART("1"),
    QUIT("2");

    private static final String INVALID_INPUT_MESSAGE = "1또는 2를 입력해주세요";

    private final String inputNumber;

    GameCommand(final String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public static GameCommand createFromInput(final String input) {
        return Arrays.stream(values())
                .filter(command -> command.inputNumber.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT_MESSAGE));
    }

    public static boolean isRestartCommand(final GameCommand command) {
        return command.equals(RESTART);
    }
}
