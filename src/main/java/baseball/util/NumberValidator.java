package baseball.util;

public class NumberValidator {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_RANGE_NUM = 1;
    private static final int MAX_RANGE_NUM = 9;
    private final static String WRONG_LENGTH_ERROR_MESSAGE = "세 자리만 입력 가능합니다.";
    private static final String WRONG_RANGE_ERROR_MESSAGE = "1 ~ 9 사이의 숫자만 입력 가능합니다.";

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
}
