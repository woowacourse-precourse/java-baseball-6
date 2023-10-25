package baseball.domain;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }
    public boolean isStrike() {
        return !isAllStrike() && strike != 0 && ball == 0;
    }

    public boolean isBall() {
        return strike == 0 && ball != 0;
    }

    public boolean isStrikeAndBall() {
        return strike != 0 && ball != 0;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isAllStrike() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
