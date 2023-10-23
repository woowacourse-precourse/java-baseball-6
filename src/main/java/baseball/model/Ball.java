package baseball.model;

public class Ball {
    private int ballCount;

    public Ball() {
        this.ballCount = 0;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public int getBallCount() {
        return this.ballCount;
    }
}
