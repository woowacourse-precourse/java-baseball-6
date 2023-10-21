package baseball.domain;

public class Judge {
    private int strike;
    private int ball;

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
        strike = 0;
        ball = 0;
    }
}
