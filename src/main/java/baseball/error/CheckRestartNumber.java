package baseball.error;

public class CheckRestartNumber {
    public static final int RESTART_INPUT_NUMBER_LENGTH = 1;
    public static final char RESTART_INPUT_NUMBER_RANGE_START = '1';
    public static final char RESTART_INPUT_NUMBER_RANGE_END = '2';
    public static final String LENGTH_EXCEPTION_MESSAGE = "잘못된 길이의 값이 입력되었습니다.";
    public static final String INVALID_VALUE_EXCEPTION_MESSAGE = "잘못된 값이 입력되었습니다.";

    public static void checkLength(String input) {
        if (input.length() != RESTART_INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public static void checkNumber(String input) {
        char inputChar = input.charAt(0);
        if (!(RESTART_INPUT_NUMBER_RANGE_START <= inputChar && inputChar <= RESTART_INPUT_NUMBER_RANGE_END)) {
            throw new IllegalArgumentException(INVALID_VALUE_EXCEPTION_MESSAGE);
        }
    }
}

