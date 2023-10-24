package judge;

public class JudgeResult {

    private final int ball;
    private final int strike;

    private JudgeResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
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
        return JudgeStatus.of(ball, strike);
    }
}
