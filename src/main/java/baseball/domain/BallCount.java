package baseball.domain;

public class BallCount {

    private int strike;
    private int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean hasNothing() {
       return strike == 0 && ball == 0;
    }
    public boolean hasStrike() {
        return strike != 0;
    }
    public boolean hasBall() {
        return ball != 0;
    }


    public int showStrike() {
        return strike;
    }

    public int showBall() {
        return ball;
    }
}
