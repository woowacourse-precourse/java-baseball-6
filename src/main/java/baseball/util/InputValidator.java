package baseball.util;

public class InputValidator {

    private static final String LENGTH_NOT_THREE_MSG = "입력의 길이가 3이 아닙니다";
    private static final String INCLUDE_CHAR_MSG = "입력에 문자가 포함되어 있습니다.";
    private static final String NOT_BETWEEN_ONE_AND_NINE_MSG = "입력값이 1~9 사이의 숫자가 아닙니다.";
    private static final String DUPLICATE_CHAR_MSG = "입력에 중복된 값이 존재합니다";
    private static final String LENGTH_NOT_ONE_MSG = "한 글자만 입력 가능합니다.";
    private static final String NOT_ONE_AND_TWO_MSG = "1 또는 2만 입력 가능합니다.";

    public static boolean isInputNumbersValid(String input) {
        if (isLengthThree(input) && isNumber(input) && isBetweenOneAndNine(input) && isNotDuplicate(input)) {
            return true;
        }
        return false;
    }

    public static boolean isRestartOrExitValid(String input) {
        if (isLengthOne(input) && isEqualToOneOrTwo(input)) {
            return true;
        }
        return false;
    }

    public static boolean isLengthThree(String input) {
        if (input.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException(LENGTH_NOT_THREE_MSG);
    }

    public static boolean isNumber(String input) {
        if (input.chars().anyMatch(c -> !Character.isDigit(c))) {
            throw new IllegalArgumentException(INCLUDE_CHAR_MSG);
        }
        return true;
    }

    public static boolean isBetweenOneAndNine(String input) {
        if (input.chars().anyMatch(c -> c < '1' || c > '9')) {
            throw new IllegalArgumentException(NOT_BETWEEN_ONE_AND_NINE_MSG);
        }
        return true;
    }

    public static boolean isNotDuplicate(String input) {
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException(DUPLICATE_CHAR_MSG);
        }
        return true;
    }

    public static boolean isLengthOne(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(LENGTH_NOT_ONE_MSG);
        }
        return true;
    }

    public static boolean isEqualToOneOrTwo(String input) {
        if (input.charAt(0) != '1' && input.charAt(0) != '2') {
            throw new IllegalArgumentException(NOT_ONE_AND_TWO_MSG);
        }
        return true;
    }
}
