package baseball;

import java.util.Map;
import java.util.HashMap;

public class BallCount {
    private final Map<String, Integer> ballCount = new HashMap<>();

    public BallCount() {
        ballCount.put("strike", 0);
        ballCount.put("ball", 0);
    }

    void addStrike() {
        ballCount.put("strike", ballCount.get("strike") + 1);
    }

    void addBall() {
        ballCount.put("ball", ballCount.get("ball") + 1);
    }

    int getStrike() {
        return ballCount.get("strike");
    }

    int getBall() {
        return ballCount.get("ball");
    }
}
