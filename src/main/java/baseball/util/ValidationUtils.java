package baseball.util;

import static baseball.util.Constants.BALL_AMOUNT;
import static baseball.util.ExceptionMessage.INVALID_LENGTH;
import static baseball.util.ExceptionMessage.INVALID_NUMBER_RANGE;
import static baseball.util.ExceptionMessage.INVALID_NUMERIC_INPUT;

import java.util.regex.Pattern;

public class ValidationUtils {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]+$");

    public static String validUserNumber(String userInput) {
        if (!parseInt(userInput)) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT.getMessage());
        }
        if (!validLength(userInput)) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
        if (!validNumberRange(userInput)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
        return userInput;
    }

    private static boolean validNumberRange(String userInput) {
        return NUMBER_REGEX.matcher(userInput).matches();
    }

    private static boolean validLength(String userInput) {
        return userInput.length() == BALL_AMOUNT;
    }

    private static boolean parseInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
