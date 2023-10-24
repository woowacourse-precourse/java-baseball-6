package baseball.model;

public class Hint {

    private static int ball;
    private static int strike;

    public Hint() {
        ball = 0;
        strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public boolean isBallZero() {
        return ball == 0;
    }

    public boolean isStrikeZero() {
        return strike == 0;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }
}
