package baseball.util;

import baseball.domain.Retry;
import java.util.ArrayList;
import java.util.List;

public class InputConvertor {

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
}
