package baseball.util;

import java.util.List;

public class InputValidator {

    private static final int BALL_COUNT = 3;
    private static final String NUMBER_FORMAT = "\\d+";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 올바른 숫자를 입력해주세요.";
    private static final String NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 3자리의 숫자를 입력해주세요.";
    private static final String RETRY_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 1 또는 2로 입력해야합니다.";

    public static void validateBalls(String rawBalls) {
        if (!isNumber(rawBalls)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNumber(String rawBalls) {
        return rawBalls.matches(NUMBER_FORMAT);
    }

    public static void validateBallsCount(List<Integer> rawBallList) {
        if (!hasThreeDigits(rawBallList)) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean hasThreeDigits(List<Integer> ballList) {
        return ballList.size() == BALL_COUNT;
    }

    public static void validateRetry(String rawRetry) {
        if (!isRetryForm(rawRetry)) {
            throw new IllegalArgumentException(RETRY_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isRetryForm(String rawRetry) {
        return rawRetry.equals("1") || rawRetry.equals("2");
    }
}
