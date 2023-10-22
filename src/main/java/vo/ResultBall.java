package vo;

public class ResultBall {

    private final int strike;
    private final int ball;
    
    public ResultBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
