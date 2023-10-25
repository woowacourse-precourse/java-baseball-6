package baseball.model;

import static baseball.NumericRange.COUNT;

public class GuessResult {

    private static final int INITIAL_ZERO_COUNT = 0;

    private int strikeCount;
    private int ballCount;

    private GuessResult(final int strikeCount, final int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static GuessResult createDefault() {
        return new GuessResult(INITIAL_ZERO_COUNT, INITIAL_ZERO_COUNT);
    }

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public void addBallCount() {
        this.ballCount++;
    }

    public boolean isGameEnd() {
        return strikeCount == COUNT.getNumber();
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
}
