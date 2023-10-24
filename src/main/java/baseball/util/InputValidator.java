package baseball.util;

public class InputValidator {

    public static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Err.INVALID_NUMERIC_INPUT.getMessage());
        }
    }

}
