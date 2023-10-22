package baseball.util;

public class InputValidator {

    public static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Err.ERROR_INPUT_NOT_NUMBERS_MESSAGE.getMessage());
        }
    }

}
