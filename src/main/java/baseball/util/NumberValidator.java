package baseball.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberValidator {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_RANGE_NUM = 1;
    private static final int MAX_RANGE_NUM = 9;
    private final static String WRONG_LENGTH_ERROR_MESSAGE = "세 자리만 입력 가능합니다.";
    private static final String WRONG_RANGE_ERROR_MESSAGE = "1 ~ 9 사이의 숫자만 입력 가능합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "서로 다른 세 자리의 숫자만 입력 가능합니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";

    public static void validateDigit(String inputNumber) {
        if (inputNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(WRONG_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateRange(String inputNumber) {
        String[] numbers = inputNumber.split("");
        for (String number : numbers) {
            if (Integer.parseInt(number) < MIN_RANGE_NUM || Integer.parseInt(number) > MAX_RANGE_NUM) {
                throw new IllegalArgumentException(WRONG_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateDuplicateNumber(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());
        if (setNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateNonNumeric(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }
}
