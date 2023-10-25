package baseball;

public class CompareResult {

    private int strike = 0;
    private int ball = 0;

    public void increaseStrike() {
        strike += 1;
    }

    public void increaseBall() {
        ball += 1;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean onlyBalls() {
        return strike == 0 && ball > 0;
    }

    public boolean onlyStrikes() {
        return strike > 0 && ball == 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
