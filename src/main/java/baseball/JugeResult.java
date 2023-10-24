package baseball;

public class JugeResult {

    private static final int SUCCESS_STRIKE = 3;

    private int ball;
    private int strike;

    public JugeResult() {
        this.ball = 0;
        this.strike = 0;
    }

    public void incrementBall() {
        this.ball++;
    }

    public void incrementStrike() {
        this.strike++;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isSuccess() {
        return strike == SUCCESS_STRIKE;
    }
}
