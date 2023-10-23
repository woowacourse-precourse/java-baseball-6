package baseball.dto;

public class Result {

    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void increaseBall() {
        ++this.ball;
    }

    public void increaseStrike() {
        ++this.strike;
    }
}
