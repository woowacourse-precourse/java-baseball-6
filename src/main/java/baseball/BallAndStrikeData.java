package baseball;

public class BallAndStrikeData {
    private final int ball;
    private final int strike;

    public BallAndStrikeData(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
