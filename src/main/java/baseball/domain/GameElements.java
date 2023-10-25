package baseball.domain;

public class GameElements {
    private int strike;
    private int ball;

    public GameElements() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void incrementStrike() {
        strike++;
    }

    public void incrementBall() {
        ball++;
    }

    public void resetElements() {
        strike = 0;
        ball = 0;
    }
}
