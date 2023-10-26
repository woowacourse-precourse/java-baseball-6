package baseball.domain;

import baseball.view.BaseballOutputView;

/*
 * 숫자야구게임 중 스트라이크와 볼 개수 관리하는 클래스
 * */

public class BaseballScore {
    private final static int MAX_COUNT = 3;
    private final static int COUNT_ZERO = 0;
    private int ballCount;
    private int strikeCount;

    public BaseballScore(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isStrikeThree() {
        return strikeCount == MAX_COUNT;
    }

    public BaseballScore() {
        this.ballCount = COUNT_ZERO;
        this.strikeCount = COUNT_ZERO;
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

    public void showBaseballScore() {
        BaseballOutputView.printBallAndStrikeCount(ballCount, strikeCount);
    }
}
