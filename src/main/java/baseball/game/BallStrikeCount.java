package baseball.game;

/**
 * 볼과 스트라이크의 개수를 관리하는 클래스입니다.
 */
public class BallStrikeCount {
    private int ballCount;
    private int strikeCount;

    public BallStrikeCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    /**
     * 볼 개수를 증가시킵니다.
     */
    public void increaseBall() {
        ballCount++;
    }

    /**
     * 스트라이크 개수를 증가시킵니다.
     */
    public void increaseStrike() {
        strikeCount++;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
