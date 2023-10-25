package baseball.model;

public class Score {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public void addStrike() {
        strike++;
    }

    public int getBall() {
        return ball;
    }

    public void addBall() {
        ball++;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

}
