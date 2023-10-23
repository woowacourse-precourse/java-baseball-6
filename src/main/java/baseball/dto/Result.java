package baseball.dto;

public class Result {
    public static final boolean ANSWER = false;
    public static final boolean WRONG = true;

    int ball;
    int strike;
    boolean status = WRONG;

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean condition) {
        this.status = condition;
    }
}
