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

}
