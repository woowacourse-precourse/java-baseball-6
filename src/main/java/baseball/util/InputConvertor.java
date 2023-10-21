package baseball.util;

import baseball.domain.Retry;
import java.util.ArrayList;
import java.util.List;

public class InputConvertor {

    private static final String RETRY_FORMAT_EXCEPTION_MESSAGE = "올바른 값이 아닙니다.";
    private static final String RETRY_INPUT_NUMBER = "1";
    private static final String END_INPUT_NUMBER = "2";
    private static final String BLANK = "";

    public static List<Integer> convertBalls(String rawBalls) {
        String[] rawBallStrings = rawBalls.split(BLANK);
        List<Integer> ballList = new ArrayList<>();
        for (String ballString : rawBallStrings) {
            int ball = Integer.parseInt(ballString);
            ballList.add(ball);
        }
        return ballList;
    }

    public static Retry converRetry(String rawRetry) {
        if (rawRetry.equals(RETRY_INPUT_NUMBER)) {
            return Retry.RETRY;
        }
        if (rawRetry.equals(END_INPUT_NUMBER)) {
            return Retry.END;
        }
        throw new IllegalArgumentException(RETRY_FORMAT_EXCEPTION_MESSAGE);
    }
}
