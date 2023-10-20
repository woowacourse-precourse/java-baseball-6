package baseball;

public class JudgeResult {

    private final int ball;
    private final int strike;
    private final JudgeStatus status;

    public JudgeResult(int ball, int strike, JudgeStatus status) {
        this.ball = ball;
        this.strike = strike;
        this.status = status;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public JudgeStatus getStatus() {
        return status;
    }
}
