package baseball;

public class JugeResult {

    private static final int SUCCESS_STRIKE = 3;

    private int ball;
    private int strike;

    public JugeResult() {
        this.ball = 0;
        this.strike = 0;
    }

    public void clear() {
        this.ball = 0;
        this.strike = 0;
    }

    public void incrementBall() {
        this.ball++;
    }

    public void incrementStrike() {
        this.strike++;
    }

    public boolean isOnlyBall() {
        return ball > 0 && strike == 0;
    }

    public boolean isOnlyStrike() {
        return ball == 0 && strike > 0;
    }

    public boolean isBallAndStrike() {
        return ball > 0 && strike > 0;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }


    public boolean isSuccess() {
        return strike == SUCCESS_STRIKE;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
