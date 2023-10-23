package baseball.domain;

import baseball.util.Validator;

public class Command {
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public static String getExit() {
        return EXIT;
    }

    public static String getRestart() {
        return RESTART;
    }

    public static boolean isExit(String input) {
        return input.equals(EXIT);
    }

    public static boolean isRestart(String input) {
        return input.equals(RESTART);
    }

    public static void validate(String input) {
        if (Validator.isInvalid(input)) {
            throw new IllegalArgumentException(Errors.getInvalidInputMessage());
        }
    }
}
