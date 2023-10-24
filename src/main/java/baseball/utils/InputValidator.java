package baseball.utils;

import java.util.List;

public class InputValidator {
    private static final List<String> STANDARD_NUMBER = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private static final int MAX_SIZE = 3;

    private InputValidator() {
    }

    public static void checkUserBallInput(final String userBallInput) {
        checkBallNumberLength(userBallInput);
    }

    private static void checkBallNumberLength(final String userBallInput) {
        if (MAX_SIZE != userBallInput.length()) {
            throw new IllegalArgumentException();
        }
    }
}
