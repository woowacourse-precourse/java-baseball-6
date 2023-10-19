package baseball.model;

public class GuessResult {

    private static final int INITIAL_ZERO_COUNT = 0;
    private static final int END_STRIKE_COUNT = 3;
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

    public String getResult() {
        if (isNothing()) {
            return NOTHING_RESULT;
        }

        if (ballCount == INITIAL_ZERO_COUNT) {
            return strikeCount + STRIKE_RESULT;
        }

        if (strikeCount == INITIAL_ZERO_COUNT) {
            return ballCount + BALL_RESULT;
        }

        return ballCount + BALL_RESULT + " " + strikeCount + STRIKE_RESULT;
    }

    public boolean isNothing() {
        return strikeCount == INITIAL_ZERO_COUNT && ballCount == INITIAL_ZERO_COUNT;
    }

    public boolean isGameEnd() {
        return strikeCount == END_STRIKE_COUNT;
    }
}
