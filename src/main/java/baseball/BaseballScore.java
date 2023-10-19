package baseball;
// 숫자야구게임 중 스트라이크와 볼 개수 관리하는 클래스
public class BaseballScore {
    private int ballCount = 0;
    private int strikeCount = 0;



    public boolean isAllCorrect() {
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    public BaseballScore(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static   boolean isBaseballScoreEqual(BaseballScore baseballScore1, BaseballScore baseballScore2) {
        if (baseballScore1.ballCount == baseballScore2.ballCount && baseballScore1.strikeCount == baseballScore2.strikeCount) {
            return true;
        }
        return false;
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

    public void printBaseballScore() {
        if (ballCount != 0) {
           System.out.print(ballCount+"볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

    }
}
