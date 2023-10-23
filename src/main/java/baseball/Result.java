package baseball;

public class Result {
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void addBall() {
        ball++;
    }

    public void addStrike() {
        strike++;
    }

    public boolean isNoting() {
        return !(isNotZeroBall() && isNotZeroStrike());
    }

    public boolean isNotZeroBall() {
        return ball != 0;
    }

    public boolean isNotZeroStrike() {
        return strike != 0;
    }
}
