package baseball.Domain;

public class Counter {
    private int strike;
    private int ball;

    public int getStrike() { return strike;}

    public int getBall() {
        return ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public Counter() {
        this.strike = 0;
        this.ball = 0;
    }
}
