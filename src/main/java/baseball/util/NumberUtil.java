package baseball.util;

import static baseball.constant.ErrorMessage.INPUT_EMPTY;
import static baseball.constant.ErrorMessage.INPUT_LENGTH_INVALID;
import static baseball.constant.ErrorMessage.INPUT_NUMBER_NOT_INTEGER;
import static baseball.constant.ErrorMessage.INPUT_NUMBER_NOT_IN_RANGE;
import static baseball.constant.ErrorMessage.INPUT_NUMBER_NOT_POSITIVE_INTEGER;
import static baseball.constant.ErrorMessage.INPUT_NUMBER_NOT_UNIQUE;

import java.util.List;

public class NumberUtil {

    protected NumberUtil() {

    }

    public static List<Integer> converStringToList(String numberString) {
        return numberString.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public static void validate(String number) {
        validateEmpty(number);
        validateLength(number);
        validateNumber(number);
        validateUnique(number);
        validateSign(number);
        validateRange(number);
    }

    protected static void validateEmpty(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(INPUT_EMPTY.getMessage());
        }
    }

    protected static void validateLength(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException(INPUT_LENGTH_INVALID.getMessage());
        }
    }

    protected static void validateNumber(String number) {
        if (number.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException(INPUT_NUMBER_NOT_INTEGER.getMessage());
        }
    }

    protected static void validateSign(String number) {
        if (number.charAt(0) == '-') {
            throw new IllegalArgumentException(INPUT_NUMBER_NOT_POSITIVE_INTEGER.getMessage());
        }
    }

    protected static void validateRange(String number) {
        if (number.chars()
                .anyMatch(n -> n < '1' || n > '9')) {
            throw new IllegalArgumentException(INPUT_NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

    protected static void validateUnique(String number) {
        if (number.chars()
                .distinct()
                .count() != number.length()) {
            throw new IllegalArgumentException(INPUT_NUMBER_NOT_UNIQUE.getMessage());
        }
    }
}
