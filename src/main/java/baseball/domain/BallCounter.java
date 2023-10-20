package baseball.domain;

import static baseball.domain.PitchResult.*;

import java.util.HashMap;
import java.util.Map;

public class BallCounter {

    private static final Map<PitchResult, Integer> ballCounter = new HashMap<>() {{
        put(BALL, 0);
        put(STRIKE, 0);
    }};

    public static void countBall() {
        ballCounter.replace(BALL, ballCounter.get(BALL) + 1);
    }

    public static void countStrike() {
        ballCounter.replace(STRIKE, ballCounter.get(STRIKE) + 1);
    }
}
