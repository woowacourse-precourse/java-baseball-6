package baseball.exception;

public class GuessNumberValidator {

    private static final String NOT_BETWEEN_ONE_AND_NINE_MSG = "입력값이 1~9 사이의 숫자가 아닙니다.";


    private GuessNumberValidator() {
    }

    public static boolean isGuessNumberValid(Integer number) {
        if (isBetweenOneAndNine(number)) {
            return true;
        }
        return false;
    }

    private static boolean isBetweenOneAndNine(Integer number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(NOT_BETWEEN_ONE_AND_NINE_MSG);
        }
        return true;
    }
}
