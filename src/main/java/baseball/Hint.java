package baseball;

/**
 * 힌트
 */
public class Hint {
    int ballCount; // 볼 개수
    int strikeCount; // 스트라이크 개수

    public Hint(int ballCount, int strikeCount){
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
