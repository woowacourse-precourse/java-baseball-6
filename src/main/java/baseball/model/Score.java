package baseball.model;

public class Score {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void incrementStrike() {
        ++strike;
    }

    public void incrementBall() {
        ++ball;
    }
}
