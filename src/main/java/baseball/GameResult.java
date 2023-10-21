package baseball;

import java.util.HashMap;

public class GameResult {
    private static int strike;
    private static int ball;
    private static final HashMap<BallScore, Integer> result = new HashMap<>();

    public void saveResult(BallScore score) {
        if (score.isStrike()) {
            strike++;
        }
        if (score.isBall()) {
            ball++;
        }
    }
    private static HashMap<BallScore, Integer> getResult() {
        result.put(BallScore.STRIKE, strike);
        result.put(BallScore.BALL, ball);
        return result;
    }
    public Integer getResult(BallScore ballScore) {
        return getResult().get(ballScore);
    }
    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
