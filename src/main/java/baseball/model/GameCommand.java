package baseball.model;

import java.util.Arrays;

public enum GameCommand {

    RESTART("1"),
    QUIT("2");

    private static final String WRONG_INPUT = "잘못된 입력입니다.";
    private static final String ENTER_RESTART_OR_QUIT = "1또는 2를 입력해주세요";

    private final String number;

    GameCommand(final String number) {
        this.number = number;
    }

    public static GameCommand make(final String input) {
        validateInput(input);

        return Arrays.stream(values())
                .filter(command -> command.number.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_INPUT));
    }

    private static void validateInput(final String input) {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException(ENTER_RESTART_OR_QUIT);
        }
    }

    private static boolean isValidInput(final String input) {
        return input.equals(RESTART.number) || input.equals(QUIT.number);
    }

    public static boolean isRestart(final GameCommand command) {
        return command.equals(RESTART);
    }
}
