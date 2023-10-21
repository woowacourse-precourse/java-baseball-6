package baseball.domain;

public class Hint {

    private int strike;

    private int ball;

    public Hint() {
        strike = 0;
        ball = 0;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }
}
