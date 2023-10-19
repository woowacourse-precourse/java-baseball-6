package baseball;
// 숫자야구게임 중 스트라이크와 볼 개수 관리하는 클래스
public class BaseballScore {
    private int ballCount = 0;
    private int strikeCount = 0;



    public BaseballScore(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    private void addBallCount(int number) {
        this.ballCount += number;

    }
    private void addStrikeCount(int number) {
        this.strikeCount += number;
    }
}
