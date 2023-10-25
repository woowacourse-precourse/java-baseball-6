package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumberValidator {
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;
    private final static int NUMBER_LENGTH = 3;
    private final static String NUMBER_LENGTH_ERROR_MESSAGE = "입력 가능 길이는 3입니다.";
    private final static String NON_INTEGER_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";
    private final static String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다.";
    private static final String OVER_RANGE_ERROR_MESSAGE = "숫자는 1과 9 사이의 숫자입니다.";
    private static final String MINUS_NUM_ERROR_MESSAGE = "마이너스는 입력 할 수 없습니다.";

    public static void validateNumberLen(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateNonInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicateNumber(String input) {
        Set<String> uniqueNumbers = new HashSet<>();
        String[] valNumber = input.split("");

        for (String number : valNumber) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateNumberRange(String input) {
        String[] valNumber = input.split("");

        for (String number : valNumber) {
            if (Integer.parseInt(number) < MIN_RANGE_NUM || Integer.parseInt(number) > MAX_RANGE_NUM) {
                throw new IllegalArgumentException(OVER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateMinusNumber(String input) {
        String[] valNumber = input.split("");

        for (String number : valNumber) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException(MINUS_NUM_ERROR_MESSAGE);
            }
        }
    }
}
