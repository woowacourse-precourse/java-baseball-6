package baseball.dto;

/**
 * 게임 한판이 진행 될 때 사용자의 게임 결과를 저장할 클래스
 */
public class Result {

    public static final boolean ANSWER = false;
    public static final boolean WRONG = true;

    private int ball;
    private int strike;
    /**
     * 정답 여부
     */
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

    /**
     * 정답 여부 반환
     *
     * @return 정답: true<br> 오답: false
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 정답 여부 설정
     *
     * @param status 정답 여부
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
