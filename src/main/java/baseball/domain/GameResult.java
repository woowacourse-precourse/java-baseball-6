package baseball.domain;

public class GameResult {

    private int strike = 0;
    private int ball = 0;

    public void strike() {
        strike++;
    }

    public void ball() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
