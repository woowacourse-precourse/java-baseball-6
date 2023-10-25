package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;
import static baseball.util.Constants.COUNT_PLUS;
import static baseball.util.Constants.DEFAULT_VALUE;

import java.util.HashMap;
import java.util.Map;

public record Result(Map<BallCount, Integer> result) {

    public static Result initialBallCount() {
        Map<BallCount, Integer> result = new HashMap<>();
        return new Result(result);
    }

    public int getBall() {
        return result.getOrDefault(BallCount.BALL, DEFAULT_VALUE);
    }

    public int getStrike() {
        return result.getOrDefault(BallCount.STRIKE, DEFAULT_VALUE);
    }

    public void updateBallCount(BallCount ballCount) {

        result.put(ballCount, result.getOrDefault(ballCount, DEFAULT_VALUE) + COUNT_PLUS);
    }

    public boolean isThreeStrike() {
        return result.getOrDefault(BallCount.STRIKE, DEFAULT_VALUE).equals(BALL_LENGTH);
    }

}