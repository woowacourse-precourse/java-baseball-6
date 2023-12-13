package baseball.global.validator;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;

public class Validator {
    public static int validateNumber(String message) {
        if (isNotNumber(message)) {
            throw CustomException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
        return Integer.parseInt(message);
    }

    private static boolean isNotNumber(String str) {
        return !str.matches("-?\\d+");
    }

    public static void validateRange(int number, int start, int end) {
        if (isInvalidRange(number, start, end)) {
            throw CustomException.from(ErrorMessage.INVALID_RANGE_ERROR);
        }
    }

    private static boolean isInvalidRange(int number, int start, int end) {
        return number < start || number > end;
    }
}
