package baseball.domain;

import java.util.HashMap;

public class GameResult {
    public static final int DEFAULT_VALUE = 0;
    public static final int SCORE = 1;
    private final HashMap<BallScore, Integer> result = new HashMap<>();

    public void saveResult(BallScore score) {
        if (score.isStrike() || score.isBall()) {
            result.put(score, result.getOrDefault(score, DEFAULT_VALUE) + SCORE);
        }
    }

    public Integer getResult(BallScore ballScore) {
        return result.getOrDefault(ballScore, DEFAULT_VALUE);
    }

}
