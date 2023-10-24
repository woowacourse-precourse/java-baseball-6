package baseball.model;

public class Game {
    private int strike;
    private int ball;

    public void init() {
        strike = 0;
        ball = 0;
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
}
