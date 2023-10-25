package baseball;

import java.util.Objects;

public class PitchResult {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";
    private static final int BALL_COUNT = 3;
    private static final int ZERO = 0;

    private int strikeCount;
    private int ballCount;

    public PitchResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public PitchResult() {
        this(ZERO, ZERO);
    }

    public void strike() {
        this.strikeCount++;
    }

    public void ball() {
        this.ballCount++;
    }

    public boolean isGameEnd() {
        return strikeCount == BALL_COUNT;
    }

    public String getHint() {
        if (strikeCount != ZERO && ballCount != ZERO) {
            return ballCount + BALL + SPACE + strikeCount + STRIKE;
        }
        if (strikeCount == ZERO && ballCount != ZERO) {
            return ballCount + BALL;
        }
        if (strikeCount != ZERO) {
            return strikeCount + STRIKE;
        }
        return NOTHING;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PitchResult that = (PitchResult) o;
        return getStrikeCount() == that.getStrikeCount() && getBallCount() == that.getBallCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStrikeCount(), getBallCount());
    }
}
