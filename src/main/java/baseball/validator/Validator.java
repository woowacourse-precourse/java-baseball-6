package baseball.validator;

import java.util.Arrays;

public class Validator {
    private static final int DIGIT_NUM = 3;
    private static final int MIN_RANGE_NUM = 1;
    private static final int MAX_RANGE_NUM = 9;
    private static final char NEGATIVE_SIGN = '-';

    private static final String NON_THREE_DIGIT_ERROR_MESSAGE = "3자리 숫자를 입력해야 합니다.";
    private static final String NON_NUMERIC_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String NEGATIVE_ERROR_MESSAGE = "양수를 입력해야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "각 자리의 숫자는 1과 9 사이의 숫자만 입력 가능합니다.";
    private static final String RESTART_OR_EXIT_ERROR_MESSAGE = "1(재시작) 또는 2(종료)를 입력해야 합니다.";
    private static final String RESTART_NUM = "1";
    private static final String EXIT_NUM = "2";

    public static void validateUserNumber(String number) {
        validateThreeDigit(number);
        validateNumeric(number);
        validateNegative(number);
        validateDuplicate(number);
        validateRange(number);
    }

    private static void validateThreeDigit(String number) {
        if (number.length() != DIGIT_NUM) {
            throw new IllegalArgumentException(NON_THREE_DIGIT_ERROR_MESSAGE);
        }
    }

    private static void validateNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    private static void validateNegative(String number) {
        if (number.charAt(0) == NEGATIVE_SIGN) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicate(String number) {
        String[] numberSplit = number.split("");

        if (numberSplit.length != Arrays.stream(numberSplit).distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void validateRange(String number) {
        String[] numberSplit = number.split("");

        for (String num : numberSplit) {
            if (Integer.parseInt(num) < MIN_RANGE_NUM || Integer.parseInt(num) > MAX_RANGE_NUM) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateRestartOrExit(String restartOrExit) {
        if (!restartOrExit.equals(RESTART_NUM) && !restartOrExit.equals(EXIT_NUM)) {
            throw new IllegalArgumentException(RESTART_OR_EXIT_ERROR_MESSAGE);
        }
    }
}
