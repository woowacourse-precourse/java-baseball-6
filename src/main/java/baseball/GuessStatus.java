package baseball;

public class GuessStatus {
    private int strike;
    private int ball;

    public GuessStatus() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike() {
        strike += 1;
    }

    public void addBall() {
        ball += 1;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }

    public boolean isNoting() {
        return this.strike == 0 && this.ball == 0;
    }

}
