package baseball.domain;

import static baseball.domain.Baseballs.BALL_SIZE;

public class ScoreBoard {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    private int ballCount;
    private int strikeCount;

    public ScoreBoard() {
        ballCount = 0;
        strikeCount = 0;
    }

    public int getBalls() {
        return ballCount;
    }

    public int getStrikes() {
        return strikeCount;
    }

    public void setScoreBoard(int balls, int strikes) {
        this.ballCount = balls;
        this.strikeCount = strikes;
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public boolean isOnlyBall() {
        return ballCount > 0 && strikeCount == 0;
    }

    public boolean isOnlyStrike() {
        return ballCount == 0 && strikeCount > 0;
    }

    public boolean isThreeStrike() {
        return strikeCount == BALL_SIZE;
    }

    @Override
    public String toString() {
        return ballCount + BALL + " " + strikeCount + STRIKE;
    }
}
