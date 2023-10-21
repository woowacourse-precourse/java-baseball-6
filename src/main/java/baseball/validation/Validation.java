package baseball.validation;

public final class Validation {
    public static void inputValidate(String input) {
        validatePlayerNumberRange(input);
        validatePlayerNumberDuplicate(input);
    }

    public static void restartValidate(String input) {
        validatePlayerRestartNumberRange(input);
    }

    private static void validatePlayerNumberRange(String input) {
        if (!input.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePlayerNumberDuplicate(String input) {
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePlayerRestartNumberRange(String input) {
        if (!input.matches("^[1-2]$")) {
            throw new IllegalArgumentException();
        }
    }
}
