package baseball.model;

public class BallStrike {
    private int strikeCount;
    private int ballCount;

    public BallStrike() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallStrike(int ball, int strike) {
        this.ballCount = ball;
        this.strikeCount = strike;
    }
}
