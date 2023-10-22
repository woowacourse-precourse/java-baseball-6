package baseball.domain.result;

public class Result {
    private int strike = 0;
    private int ball = 0;

    public Result() {
    }

    public void increaseStrike() {
        this.strike++;
    }

    public void increaseBall() {
        this.ball++;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }
}
