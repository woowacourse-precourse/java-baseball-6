package judge;

public class JudgeResult {

    private final int ball;
    private final int strike;
    private final JudgeStatus status;

    private JudgeResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
        this.status = JudgeStatus.getJudgeStatus(ball, strike);
    }

    public static JudgeResult of(int ball, int strike) {
        return new JudgeResult(ball, strike);
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
