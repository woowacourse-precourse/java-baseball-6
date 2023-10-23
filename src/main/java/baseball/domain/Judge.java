package baseball.domain;

public class Judge {
    public static final int INIT_VALUE = 0;
    private int strike;
    private int ball;

    public Judge() {
        strike = INIT_VALUE;
        ball = INIT_VALUE;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void reset() {
        strike = INIT_VALUE;
        ball = INIT_VALUE;
    }
}
