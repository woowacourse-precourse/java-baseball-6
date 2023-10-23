package baseball.validation;

import static baseball.constant.Constant.NUMBER_BASEBALL_STR_LENGTH;

import java.util.regex.Pattern;

public class InputValidator {

    static final String REGEXP_PATTERN_ONE_TO_NINE_NUMBER = "^[1-9]*$";
    static final String REGEXP_PATTERN_ONE_TO_TWO_NUMBER = "^[1-2]*$";

    public static void validateInputNumber(String inputStr) {
        if (!(isRangeOneToNine(inputStr) && isLengthThree(inputStr))) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRestartOrClose(String inputStr) {
        if (!isOneOrTwo(inputStr)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isRangeOneToNine(String inputStr) {
        return Pattern.matches(REGEXP_PATTERN_ONE_TO_NINE_NUMBER, inputStr);
    }

    private static boolean isLengthThree(String inputStr) {
        return inputStr.length() == NUMBER_BASEBALL_STR_LENGTH;
    }

    private static boolean isOneOrTwo(String inputStr) {
        return Pattern.matches(REGEXP_PATTERN_ONE_TO_TWO_NUMBER, inputStr);
    }
}
