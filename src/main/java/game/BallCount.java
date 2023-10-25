package game;

import java.util.List;
import java.util.stream.IntStream;

public class BallCount {

    private final int strikes;
    private final int balls;

    public BallCount(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
