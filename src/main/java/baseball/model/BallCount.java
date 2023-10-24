package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class BallCount {
    private final Map<String, Integer> ballCount = new HashMap<>();

    public BallCount() {
        ballCount.put("strike", 0);
        ballCount.put("ball", 0);
    }

    public void addStrike() {
        ballCount.put("strike", ballCount.get("strike") + 1);
    }

    public void addBall() {
        ballCount.put("ball", ballCount.get("ball") + 1);
    }

    public int getStrike() {
        return ballCount.get("strike");
    }

    public int getBall() {
        return ballCount.get("ball");
    }
}
