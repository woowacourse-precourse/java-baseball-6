package baseball;

public class Count {

    private int strike;
    private int ball;


    public Count(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
