package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    private static final String RETRY_FORMAT_EXCEPTION_MESSAGE = "올바른 값이 아닙니다.";

    public static List<Integer> convertBalls(String rawBalls) {
        String[] rawBallStrings = rawBalls.split("");
        List<Integer> ballList = new ArrayList<>();
        for (String ballString : rawBallStrings) {
            int ball = Integer.parseInt(ballString);
            ballList.add(ball);
        }
        return ballList;
    }

    public static Retry converRetry(String rawRetry) {
        if (rawRetry.equals("1")) {
            return Retry.RETRY;
        }
        if (rawRetry.equals("2")) {
            return Retry.END;
        }
        throw new IllegalArgumentException(RETRY_FORMAT_EXCEPTION_MESSAGE);
    }
}
