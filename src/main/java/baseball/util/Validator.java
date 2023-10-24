package baseball.util;

import baseball.exception.NumExceptionEnum;

public class Validator {

    public static void checkRxNums(String nums, int numSize) {

        if (nums.length() != numSize) {
            throw new IllegalArgumentException(NumExceptionEnum.WRONG_SIZE_NUM.msg);
        }

        if (isNumber(nums)) {
            throw new IllegalArgumentException(NumExceptionEnum.NOT_INTEGER.msg);
        }
    }

    private static boolean isNumber(String value) {
        return value != null && value.matches("^[^0]\\d*");
    }
}
