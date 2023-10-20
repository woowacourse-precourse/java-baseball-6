package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    public static List<Integer> convertBalls(String rawBalls) {
        String[] rawBallStrings = rawBalls.split("");
        List<Integer> ballList = new ArrayList<>();
        for (String ballString : rawBallStrings) {
            int ball = Integer.parseInt(ballString);
            ballList.add(ball);
        }
        return ballList;
    }
}
