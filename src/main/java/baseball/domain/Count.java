package baseball.domain;

public class Count {

    private int ball;
    private int strike;

    public Count() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBallCount() {
        return ball;
    }

    public int getStrikeCount() {
        return strike;
    }

    public void setCount(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean is3Strike() {
        return strike == 3;
    }
}
