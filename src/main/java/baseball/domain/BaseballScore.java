package baseball.domain;

import baseball.view.BaseballPrint;

// 숫자야구게임 중 스트라이크와 볼 개수 관리하는 클래스
public class BaseballScore {
    private int ballCount = 0;
    private int strikeCount = 0;


    public boolean isStrikeThree() {
        return strikeCount == 3;
    }

    public BaseballScore(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static boolean isBaseballScoreEqual(BaseballScore baseballScore1, BaseballScore baseballScore2) {
        return baseballScore1.ballCount == baseballScore2.ballCount
                && baseballScore1.strikeCount == baseballScore2.strikeCount;
    }

    public void addBallCount(int count) {
        this.ballCount += count;

    }

    public void addStrikeCount(int count) {
        this.strikeCount += count;
    }

    public void printBaseballScore() {
        BaseballPrint.printBallAndStrikeCount(ballCount, strikeCount);
    }
}
