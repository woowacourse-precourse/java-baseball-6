package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class BallCounter {

    private static final Map<PitchResult, Integer> ballCounter = new HashMap<>();

    private BallCounter() {
    }

    public static void countBall() {
        ballCounter.put(PitchResult.BALL, getCountOfBall() + 1);
    }

    public static void countStrike() {
        ballCounter.put(PitchResult.STRIKE, getCountOfStrike() + 1);
    }

    public static boolean isAllStrike(int digitNumber) {
        return getCountOfStrike() == digitNumber;
    }

    public static void reset() {
        ballCounter.replace(PitchResult.BALL, 0);
        ballCounter.replace(PitchResult.STRIKE, 0);
    }

    public static int getCountOfBall() {
        return ballCounter.getOrDefault(PitchResult.BALL, 0);
    }

    public static int getCountOfStrike() {
        return ballCounter.getOrDefault(PitchResult.STRIKE, 0);
    }
}
