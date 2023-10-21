package baseball;

public class PitchResult {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";
    private static final int BALL_COUNT = 3;
    private final int strikeCount;
    private final int ballCount;

    public PitchResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public PitchResult strike() {
        return new PitchResult(strikeCount + 1, ballCount);
    }

    public PitchResult ball() {
        return new PitchResult(strikeCount, ballCount + 1);
    }

    public boolean isGameEnd() {
        return strikeCount == BALL_COUNT;
    }

    public String getHint() {
        if (strikeCount != 0 && ballCount != 0) {
            return ballCount + BALL + SPACE + strikeCount + STRIKE;
        }
        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + BALL;
        }
        if (strikeCount != 0) {
            return strikeCount + STRIKE;
        }
        return NOTHING;
    }
}
