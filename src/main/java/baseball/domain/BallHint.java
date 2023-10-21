package baseball.domain;

public class BallHint {

    private int strike;
    private int ball;

    public boolean isNothing() {
        return strike + ball == 0;
    }
}
