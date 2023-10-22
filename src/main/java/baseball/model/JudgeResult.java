package baseball.model;

public class JudgeResult {
    private int strike = 0;
    private int ball = 0;

    public JudgeResult() {
    }

    public int getStrike() {
        return strike;
    }

    public void strike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public void ball() {
        this.ball++;
    }
}
