package baseball.model;

import static baseball.model.Game.ZERO_COUNT;

public class Ball {
    private int ballCount;

    public Ball() {
        this.ballCount = 0;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public boolean isZeroBall() {
        return this.ballCount == 0;
    }

    public String getComment() {
        if (ballCount > 0) {
            return ballCount + "볼";
        }
        return ZERO_COUNT;
    }

}
