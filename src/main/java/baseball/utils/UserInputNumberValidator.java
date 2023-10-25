package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class UserInputNumberValidator {

    private static final int NUMBER_SIZE = 3;
    private static final String INVALID_NUMBER_SIZE_MESSAGE = "입력 숫자의 길이가 3이 아닙니다.";
    private static final String NON_DIGIT_ERROR_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "입력값에 중복된 값이 있습니다.";

    public static void validate(String userInputNumber) {
        validateLength(userInputNumber);
        validateDigit(userInputNumber);
        validateDuplication(userInputNumber);
    }

    private static void validateLength(String userInputNumber) {
        if (userInputNumber.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE_MESSAGE);
        }
    }

    private static void validateDigit(String userInputNumber) {
        for (char ch : userInputNumber.toCharArray()) {
            if (!Character.isDigit(ch) || ch < '1' || ch > '9') {
                throw new IllegalArgumentException(NON_DIGIT_ERROR_MESSAGE);
            }
        }
    }

    private static void validateDuplication(String userInputNumber) {
        Set<Character> set = new HashSet<>();
        for (char ch : userInputNumber.toCharArray()) {
            if (set.contains(ch)) {
                throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
            }
            set.add(ch);
        }
    }

}
