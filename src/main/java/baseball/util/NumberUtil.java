package baseball.util;

import static baseball.constant.ErrorMessage.INPUT_EMPTY;
import static baseball.constant.ErrorMessage.INPUT_LENGTH_INVALID;
import static baseball.constant.ErrorMessage.INPUT_NUMBER_NOT_INTEGER;
import static baseball.constant.ErrorMessage.INPUT_NUMBER_NOT_IN_RANGE;
import static baseball.constant.ErrorMessage.INPUT_NUMBER_NOT_POSITIVE_INTEGER;
import static baseball.constant.ErrorMessage.INPUT_NUMBER_NOT_UNIQUE;
import static baseball.util.validateCondition.LengthCondition.isNotValid;
import static baseball.util.validateCondition.RangeCondition.isNotInRange;

import java.util.List;
import java.util.stream.Collectors;

public class NumberUtil {

    protected NumberUtil() {

    }

    public static List<Integer> convertStringToList(String numberString) {
        return numberString.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public static String convertListToString(List<Integer> numberList) {
        return numberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
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
        if (isNotValid(number.length())) {
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
                .anyMatch(n -> isNotInRange(Character.getNumericValue(n)))) {
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
