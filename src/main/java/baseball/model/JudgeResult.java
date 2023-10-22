package baseball.model;

import baseball.util.Constants;

import java.util.HashMap;
import java.util.Map;

public class JudgeResult {
    private static final int NO_COUNT = 0;
    private static final int ONE_COUNT = 1;
    private final Map<BallCount, Integer> judgeResult;

    public JudgeResult() {
        judgeResult = new HashMap<>();
    }

    public void addResult(BallCount ballCount) {
        judgeResult.put(ballCount, judgeResult.getOrDefault(ballCount, NO_COUNT) + ONE_COUNT);
    }

    public boolean hasBall() {
        return judgeResult.getOrDefault(BallCount.BALL, NO_COUNT) != NO_COUNT;
    }

    public boolean hasStrike() {
        return judgeResult.getOrDefault(BallCount.STRIKE, NO_COUNT) != NO_COUNT;
    }

    public boolean isNothing() {
        return !hasBall() && !hasStrike();
    }

    public int getBallCount() {
        return judgeResult.get(BallCount.BALL);
    }

    public int getStrikeCount() {
        return judgeResult.get(BallCount.STRIKE);
    }

    public boolean isGameSuccess() {
        return judgeResult.getOrDefault(BallCount.STRIKE, NO_COUNT) == Constants.BALL_LENGTH;
    }

}
