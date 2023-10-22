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

    public void setBallCount(int count) {
        this.ball = count;
    }

    public void setStrikeCount(int count) {
        this.strike = count;
    }
}
