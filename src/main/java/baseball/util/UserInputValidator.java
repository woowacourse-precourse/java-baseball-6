package baseball.util;

import baseball.util.constants.BaseballGameConstants;

public class UserInputValidator {
    private static final String EXCEPTION_MESSAGE_FORMAT = "%s. 입력값: %s";

    private static final String WRONG_RESTART_OPTION_MESSAGE = "입력은 %s 또는 %s만 가능합니다".formatted(
            BaseballGameConstants.RESTART_OPTION_RESTART, BaseballGameConstants.RESTART_OPTION_EXIT);
    private static final String WRONG_NUMBERS_MESSAGE = "%d부터 %d까지의 서로 다른 %d자리 숫자만 입력 가능합니다. ".formatted(
            BaseballGameConstants.MIN_NUM, BaseballGameConstants.MAX_NUM, BaseballGameConstants.NUM_LENGTH);
    private static final String WRONG_LENGTH_MESSAGE = "%d자리 숫자만 입력 가능합니다".formatted(
            BaseballGameConstants.NUM_LENGTH);
    private static final String NUMBER_OUT_OF_RANGE_MESSAGE = "%d부터 %d까지 정수만 입력 가능합니다".formatted(
            BaseballGameConstants.MIN_NUM, BaseballGameConstants.MAX_NUM);
    private static final String NUMBER_DUPLICATED_MESSAGE = "중복된 숫자는 입력할 수 없습니다";

    private static void throwIllegalArgumentException(Object... args) {
        throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_FORMAT, args));
    }

    public static boolean validateAndCheckIsRestart(String input) {
        if (input.equals(BaseballGameConstants.RESTART_OPTION_RESTART)
                || input.equals(BaseballGameConstants.RESTART_OPTION_EXIT)) {
            return input.equals(BaseballGameConstants.RESTART_OPTION_RESTART);
        }
        throwIllegalArgumentException(WRONG_RESTART_OPTION_MESSAGE, input);
        return false;
    }

    public static int[] validateNumbersAndConvertToArray(String input) {
        validateInputLength(input);

        int[] result = new int[BaseballGameConstants.NUM_LENGTH];
        for (int i = 0; i < BaseballGameConstants.NUM_LENGTH; i++) {
            int n = parseCharToIntAndValidateRange(input.charAt(i));
            validateDuplicated(n, result, i);
            result[i] = n;
        }
        return result;
    }

    private static void validateInputLength(String input) {
        if (input.length() != BaseballGameConstants.NUM_LENGTH) {
            throwIllegalArgumentException(WRONG_NUMBERS_MESSAGE + WRONG_LENGTH_MESSAGE, input);
        }
    }

    private static int parseCharToIntAndValidateRange(char c) {
        int n = c - '0';
        if (n < BaseballGameConstants.MIN_NUM || n > BaseballGameConstants.MAX_NUM) {
            throwIllegalArgumentException(WRONG_NUMBERS_MESSAGE + NUMBER_OUT_OF_RANGE_MESSAGE, c);
        }
        return n;
    }

    private static void validateDuplicated(int target, int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                throwIllegalArgumentException(WRONG_NUMBERS_MESSAGE + NUMBER_DUPLICATED_MESSAGE, target);
            }
        }
    }
}
