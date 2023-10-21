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
    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
