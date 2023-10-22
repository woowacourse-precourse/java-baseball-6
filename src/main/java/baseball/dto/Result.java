package baseball.dto;

public class Result {
    public static final boolean ANSWER = false;
    public static final boolean WRONG = true;

    int ball;
    int strike;
    boolean condition = WRONG;

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

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }
}
