package baseball;

import java.util.Map;
import java.util.HashMap;

public class BallCount {
    private final Map<String, Integer> ballCount = new HashMap<>();

    public BallCount() {
        this.ballCount.put("strike", 0);
        this.ballCount.put("ball", 0);
    }

    void addStrike() {
        this.ballCount.put("strike", this.ballCount.get("strike") + 1);
    }

    void addBall() {
        this.ballCount.put("ball", this.ballCount.get("ball") + 1);
    }

    int getStrike() {
        return this.ballCount.get("strike");
    }

    int getBall() {
        return this.ballCount.get("ball");
    }
}
