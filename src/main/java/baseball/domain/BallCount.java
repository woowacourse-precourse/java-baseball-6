package baseball.domain;

public class BallCount {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void increaseStrike() {
        ++strike;
    }

    public void increaseBall() {
        ++ball;
    }

}
