package baseball.exception;

public class GuessNumberValidator {
    private static final String LENGTH_NOT_THREE_MSG = "입력의 길이가 3이 아닙니다";
    private static final String NOT_BETWEEN_ONE_AND_NINE_MSG = "입력값이 1~9 사이의 숫자가 아닙니다.";
    private static final String DUPLICATE_CHAR_MSG = "입력에 중복된 값이 존재합니다";

    private GuessNumberValidator() {
    }

    public static boolean isGuessNumbersValid(String input) {
        if (isLengthThree(input) && isNotDuplicate(input)) {
            return true;
        }
        return false;
    }

    public static boolean isGuessNumberValid(Integer number) {
        if (isBetweenOneAndNine(number)) {
            return true;
        }
        return false;
    }

    private static boolean isLengthThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(LENGTH_NOT_THREE_MSG);
        }
        return true;
    }

    private static boolean isBetweenOneAndNine(Integer number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(NOT_BETWEEN_ONE_AND_NINE_MSG);
        }
        return true;
    }

    private static boolean isNotDuplicate(String input) {
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException(DUPLICATE_CHAR_MSG);
        }
        return true;
    }
}
