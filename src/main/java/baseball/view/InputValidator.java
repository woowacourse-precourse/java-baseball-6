package baseball.view;

public final class InputValidator {
    public static void validateIsNumeric(String input) {
        boolean isNumeric = input.chars().
                allMatch(number -> '0' <= number && number <= '9');

        if (!isNumeric) {
            throw new IllegalArgumentException();
        }
    }
}
