package baseball;
// 숫자야구게임 중 스트라이크와 볼 개수 관리하는 클래스
public class BaseballScore {
    private int ballCount = 0;
    private int strikeCount = 0;



    public BaseballScore(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public void addBallCount() {
        this.ballCount += 1;

    }
    public void addStrikeCount() {
        this.strikeCount += 1;
    }

    @Override
    public String toString() {
        return "BaseballScore{" +
                "ballCount=" + ballCount +
                ", strikeCount=" + strikeCount +
                '}';
    }
}
