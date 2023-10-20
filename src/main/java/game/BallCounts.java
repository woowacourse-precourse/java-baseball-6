package game;

public class BallCounts {

    private int ball;
    private int strike;

    public BallCounts(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    @Override
    public String toString() {
        return ball + ", " + strike;
    }
}
