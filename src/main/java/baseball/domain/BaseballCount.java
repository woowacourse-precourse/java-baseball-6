package baseball.domain;

/**
 * 볼과 스트라이크 개수를 전달하기 위한 도메인 클래스
 */
public class BaseballCount {
    private int ball;
    private int strike;

    public BaseballCount(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
