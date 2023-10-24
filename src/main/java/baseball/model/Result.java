package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<BallCount, Integer> result;

    public Result(Map<BallCount, Integer> result) {
        this.result = result;
    }

    public static Result initialBallCount() {
        Map<BallCount, Integer> result = new HashMap<>();
        result.put(BallCount.BALL, 0);
        result.put(BallCount.STRIKE, 0);
        return new Result(result);
    }


    public void updateBallCount(BallCount ballCount) {
        result.put(ballCount, result.get(ballCount) + 1);
    }

    public Map<BallCount, Integer> getResult() {
        return result;
    }
}