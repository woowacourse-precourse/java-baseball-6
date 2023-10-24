package baseball.utils;

public class Validator {

    private static final int MAX_LENGTH = 3;
    private static final int MINIMUM_DIGIT_VALUE = 1;
    private static final int MAXIMUM_DIGIT_VALUE = 9;
    private static final String ONLY_INT = "숫자를 입력 해 주세요.";
    private static final String INVALID_LENGTH_MESSAGE = "세 자리 숫자를 입력 해 주세요.";
    private static final String OUT_OF_RANGE_MESSAGE = "각 숫자는 1~9 사이 여야 합니다.";
    private static final String DUPLICATE_DIGITS_MESSAGE = "세 숫자는 서로 달라야 합니다.";

    public static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ONLY_INT);
        }
    }

    public static void validateIsNumeric(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ONLY_INT);
        }
    }

    public static void validateLength(String input) {
        if (input.length() != MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    public static void validateDigitsInRange(String input) {
        for (char digit : input.toCharArray()) {
            int value = digit - '0';
            if (value < MINIMUM_DIGIT_VALUE || value > MAXIMUM_DIGIT_VALUE) {
                throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
            }
        }
    }

    public static void validateDigitsAreDistinct(String inputString) {
        char[] inputArr = inputString.toCharArray();
        if (inputArr[0] == inputArr[1] || inputArr[0] == inputArr[2]
            || inputArr[1] == inputArr[2]) {
            throw new IllegalArgumentException(DUPLICATE_DIGITS_MESSAGE);
        }
    }

}
