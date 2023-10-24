package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class RoundResult {

    private final static int GAME_END_COUNT = 3;

    private static final int DEFAULT_VALUE = 0;

    private final Map<BallType, Integer> results = new HashMap<>();

    public void add(BallType ballType) {
        if (ballType.isNotNothing()) {
            results.put(ballType, results.getOrDefault(ballType, DEFAULT_VALUE) + 1);
        }
    }

    public boolean isNothing() {
        return results.isEmpty();
    }

    public int getStrikeCount() {
        return results.getOrDefault(BallType.STRIKE, DEFAULT_VALUE);
    }

    public int getBallCount() {
        return results.getOrDefault(BallType.BALL, DEFAULT_VALUE);
    }

    public boolean isGameEnd() {
        return getStrikeCount() == GAME_END_COUNT;
    }
}