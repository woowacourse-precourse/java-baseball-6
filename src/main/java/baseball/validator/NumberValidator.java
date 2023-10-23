package baseball.validator;

import static baseball.constant.MessageConstants.CANNOT_INSTANTIATE;
import static baseball.constant.MessageConstants.DUPLICATE_NUMBER;
import static baseball.constant.MessageConstants.LENGTH_MUST_BE_ONE;
import static baseball.constant.MessageConstants.LENGTH_MUST_BE_THREE;
import static baseball.constant.MessageConstants.NATURAL_NUMBER;
import static baseball.constant.MessageConstants.NOT_NUMBER;
import static baseball.constant.MessageConstants.NUMBER_MUST_BE_ONE_OR_TWO;
import static baseball.constant.NumberConstants.EXIT_NUMBER_STRING;
import static baseball.constant.NumberConstants.MAX_VALUE;
import static baseball.constant.NumberConstants.MIN_VALUE;
import static baseball.constant.NumberConstants.ONE_LENGTH;
import static baseball.constant.NumberConstants.RESTART_NUMBER_STRING;
import static baseball.constant.NumberConstants.THREE_LENGTH;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberValidator {

    private NumberValidator() {
        throw new AssertionError(CANNOT_INSTANTIATE);
    }

    public static void validateNaturalNumber(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(NATURAL_NUMBER);
        }
    }

    public static void validateDuplicateNumber(int number) {
        String numberString = String.valueOf(number);
        Set<Character> characters = convertStringToSet(numberString);
        if (characters.size() < numberString.length()) {
            throw new IllegalArgumentException(number + DUPLICATE_NUMBER);
        }
    }

    public static void validateAllDigits(String input) {
        for (char c : input.toCharArray()) {
            validateEachDigit(input, c);
            validateNaturalNumber(Integer.parseInt(String.valueOf(c)));
        }
    }

    private static void validateEachDigit(String input, char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException(input + NOT_NUMBER);
        }
    }

    private static Set<Character> convertStringToSet(String numberString) {
        Set<Character> resultSet = new HashSet<>();
        for (char c : numberString.toCharArray()) {
            resultSet.add(c);
        }

        return resultSet;
    }

    public static void validateThreeLength(String input) {
        if (input.length() != THREE_LENGTH) {
            throw new IllegalArgumentException(input + LENGTH_MUST_BE_THREE);
        }
    }

    public static void validateOneLength(String input) {
        if (input.length() != ONE_LENGTH) {
            throw new IllegalArgumentException(input + LENGTH_MUST_BE_ONE);
        }
    }

    public static void validateOneOrTwo(String input) {
        if (!Objects.equals(input, RESTART_NUMBER_STRING) && !Objects.equals(input, EXIT_NUMBER_STRING)) {
            throw new IllegalArgumentException(input + NUMBER_MUST_BE_ONE_OR_TWO);
        }
    }

    public static boolean isBelowThreeLength(int size) {
        return size < THREE_LENGTH;
    }

}
