package baseball.util;

import static baseball.util.NumberConst.BALL_LENGTH;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    private static final String REGEXP_NUMBER = "^[1-9]+$";

    public static void getValidatedPlayerNumber(String input) {
        if (!isInRange(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE.getMessage());
        }
        if (!isLengthThree(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LENGTH.getMessage());
        }
        if (!isUniqueNumber(input)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    private static boolean isUniqueNumber(String input) {
        long uniqueNumberCount = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .distinct()
                .count();
        return uniqueNumberCount == BALL_LENGTH;
    }

    private static boolean isInRange(String input) {
        return Pattern.matches(REGEXP_NUMBER, input);
    }

    private static boolean isLengthThree(String input) {
        return input.length() == BALL_LENGTH;
    }


}
