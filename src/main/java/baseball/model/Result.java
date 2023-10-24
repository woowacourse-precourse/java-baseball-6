package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<BallCount, Integer> result;

    private Result(Map<BallCount, Integer> result) {
        this.result = result;
    }

    public static Result initialBallCount() {
        Map<BallCount, Integer> result = new HashMap<>();
        return new Result(result);
    }

    public int getBall() {
        return result.getOrDefault(BallCount.BALL, 0);
    }

    public int getStrike() {
        return result.getOrDefault(BallCount.STRIKE, 0);
    }

    public void updateBallCount(BallCount ballCount) {

        result.put(ballCount, result.getOrDefault(ballCount, 0) + 1);
    }


    public boolean isThreeStrike() {
        return result.getOrDefault(BallCount.STRIKE, 0) == BALL_LENGTH;
    }
}