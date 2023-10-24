package validator;

import java.util.Arrays;

public class NumbersValidator {
    private final static int INPUT_DIGIT = 3;
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;
    private final static String INVALID_DIGIT_ERROR_MESSAGE = "입력 길이는 3입니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";
    private final static String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다.";
    private static final String OUT_RANGE_ERROR_MESSAGE = "숫자는 1과 9 사이의 숫자입니다.";

    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateDigit(String input) {
        if (input.length() != INPUT_DIGIT) {
            throw new IllegalArgumentException(INVALID_DIGIT_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicateNumber(String input) {
        String[] numbers = input.split("");
        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateRange(String input) {
        String[] numbers = input.split("");
        for (String number : numbers) {
            if (Integer.parseInt(number) < MIN_RANGE_NUM || Integer.parseInt(number) > MAX_RANGE_NUM) {
                throw new IllegalArgumentException(OUT_RANGE_ERROR_MESSAGE);
            }
        }
    }
}