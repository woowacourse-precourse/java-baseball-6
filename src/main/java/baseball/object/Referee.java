package baseball.object;

public class Referee {
    int ball;
    int strike;
    int count;

    public Referee(int ball, int strike, int count) {
        this.ball = ball;
        this.strike = strike;
        this.count = count;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
