package baseball.validation;

import java.util.regex.Pattern;

public class InputValidator {

    static final String REGEXP_PATTERN_NUMBER = "^[1-9]*$";

    public static void validateInputNumber(String inputStr) {
        if (!(isRangeOneToNine(inputStr) && isLengthThree(inputStr))) {
            throw new IllegalArgumentException();
        }

    }

    private static boolean isRangeOneToNine(String inputStr) {
        return Pattern.matches(REGEXP_PATTERN_NUMBER, inputStr);
    }

    private static boolean isLengthThree(String inputStr) {
        return inputStr.length() == 3;
    }
}
