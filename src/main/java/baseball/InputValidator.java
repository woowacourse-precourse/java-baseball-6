package baseball;

public class InputValidator {

    private static final String NUMBER_FORMAT = "\\d+";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "올바른 숫자를 입력해주세요.";

    public static void validateBalls(String rawBalls) {
        if (!isNumber(rawBalls)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNumber(String rawBalls) {
        return rawBalls.matches(NUMBER_FORMAT);
    }
}
