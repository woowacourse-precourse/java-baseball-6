package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class JudgeResult {
    private final Map<BallCount, Integer> judgeResult;

    public JudgeResult() {
        judgeResult = new HashMap<>();
    }

    public void addResult(BallCount ballCount) {
        judgeResult.put(ballCount, judgeResult.getOrDefault(ballCount, 0) + 1);
    }

    public boolean hasBall() {
        return judgeResult.getOrDefault(BallCount.BALL, 0) != 0;
    }

    public boolean hasStrike() {
        return judgeResult.getOrDefault(BallCount.STRIKE, 0) != 0;
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

}
