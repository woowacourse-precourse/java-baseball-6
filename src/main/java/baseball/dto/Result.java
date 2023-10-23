package baseball.dto;

/**
 * 게임 한판이 진행 될 때 사용자의 게임 결과를 저장할 클래스
 */
public class Result {
    /**
     * Result클래스의 status 변수와 값 비교할 상수
     */
    public static final boolean ANSWER = false;
    /**
     * Result클래스의 status 변수와 값 비교할 상수
     */
    public static final boolean WRONG = true;

    private int ball;
    private int strike;
    private boolean status = WRONG;

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
