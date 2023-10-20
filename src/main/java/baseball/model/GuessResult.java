package baseball.model;

import static baseball.Constants.NUMBER_COUNTS;

public class GuessResult {

    private static final int INITIAL_ZERO_COUNT = 0;
    private static final String NOTHING_RESULT = "낫싱";
    private static final String BALL_RESULT = "볼";
    private static final String STRIKE_RESULT = "스트라이크";

    private int strikeCount = INITIAL_ZERO_COUNT;
    private int ballCount = INITIAL_ZERO_COUNT;

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public void addBallCount() {
        this.ballCount++;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isNothing() {
        return strikeCount == INITIAL_ZERO_COUNT && ballCount == INITIAL_ZERO_COUNT;
    }

    public boolean isGameEnd() {
        return strikeCount == NUMBER_COUNTS;
    }
}
