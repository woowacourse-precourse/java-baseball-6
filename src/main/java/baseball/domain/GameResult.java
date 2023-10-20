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

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean hasBall() {
        return ball != 0;
    }

    public boolean hasStrike() {
        return strike != 0;
    }
}
