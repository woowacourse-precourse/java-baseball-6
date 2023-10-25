package baseball.game;

import java.util.List;
import java.util.Map;

public class GameCalculator {

    public Result getResult(Map<Integer, Integer> answer, List<Integer> ballNumber, int ballCount, int strikeCount) {
        for (int i = 0; i <=2; i++) {
            Integer now = ballNumber.get(i);
            if (answer.containsKey(now)) {
                if (answer.get(now) == answer.size() - i-1) {
                    strikeCount++;
                } else {
                    ballCount++;
                }

            }
        }
        return new Result(ballCount, strikeCount);
    }

    public record Result(int ballCount, int strikeCount) {
    }

}
