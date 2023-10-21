package baseball.validation;

public final class Validation {
    public static void inputValidate(String input) {
        validateNumberRange(input);
        validateNumberLength(input);
        validateNumberDuplicate(input);
    }

    private static void validateNumberRange(String input) {
        if (!input.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberLength(String input) {
        if (String.valueOf(input).length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberDuplicate(String input) {
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException();
        }
    }
}
