package baseball.valueObject;

public class ResultBall {

    private final int ball;
    private final int strike;


    public ResultBall(int ball, int strike) {
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
