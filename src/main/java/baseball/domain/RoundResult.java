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

    public boolean isGameEnd() {
        return results.getOrDefault(BallType.STRIKE, 0) == GAME_END_COUNT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isNothing()) {
            return BallType.NOTHING.toString();
        }

        for (BallType ballType : BallType.values()) {
            Integer count = results.get(ballType);
            if (count != null && count > 0) {
                sb.append(count).append(ballType).append(" ");
            }
        }
        return sb.toString().trim();
    }
}