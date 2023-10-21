package baseball.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {
    public static String isValidInput(String input) {
        isEmpty(input);
        isLengthThree(input);
        isInRange(input);
        isDuplicate(input);
        return input;
    }

    public static String isValidRestartInput(String input) {
        isEmpty(input);
        isRestartInputInRange(input);
        return input;
    }

    public static void isEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE);
        }
    }

    public static void isLengthThree(String input) {
        if (input.length() != Constants.NUMBER_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_THREE_DIGIT_NUMBER);
        }
    }

    public static void isInRange(String input) {
        if (!Pattern.matches(Constants.NON_ZERO_DIGITS_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NON_ZERO_SINGLE_DIGIT);
        }
    }

    public static void isRestartInputInRange(String input) {
        if (!Pattern.matches(Constants.ONE_OR_TWO_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ONE_OR_TWO);
        }
    }

    public static void isDuplicate(String input) {
        Set<Character> number = new HashSet<>();
        for (char digit : input.toCharArray()) {
            number.add(digit);
        }
        if (number.size() != Constants.NUMBER_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_DISTINCT_NUMBERS);
        }
    }
}
