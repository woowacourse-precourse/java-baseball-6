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

    public int getBallCount() {
        return judgeResult.getOrDefault(BallCount.BALL, NO_COUNT);
    }

    public int getStrikeCount() {
        return judgeResult.getOrDefault(BallCount.STRIKE, NO_COUNT);
    }

    public int getNothingCount() {
        return judgeResult.getOrDefault(BallCount.NOTHING, NO_COUNT);
    }

    public boolean isGameSuccess() {
        return judgeResult.getOrDefault(BallCount.STRIKE, NO_COUNT) == Constants.BALL_LENGTH;
    }

}
