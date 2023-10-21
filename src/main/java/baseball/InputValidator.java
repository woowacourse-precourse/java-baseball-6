package baseball;

import java.util.List;

public class InputValidator {

    private static final int BALL_COUNT = 3;
    private static final String NUMBER_FORMAT = "\\d+";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "올바른 숫자를 입력해주세요.";
    private static final String NUMBER_COUNT_EXCEPTION_MESSAGE = "3자리의 숫자를 입력해주세요.";

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

}
