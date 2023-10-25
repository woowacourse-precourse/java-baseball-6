package baseball;

public class GuessResult {
    private int strikeCount;
    private int ballCount;

    GuessResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public String toString() {
        if (strikeCount == 0 && ballCount == 0) {
            return MessageUtil.WORD_NOTHING;
        } else if (strikeCount > 0 && ballCount > 0) {
            return ballCount + MessageUtil.WORD_BALL + " " + strikeCount + MessageUtil.WORD_STRIKE;
        } else if (ballCount > 0 ) {
            return ballCount + MessageUtil.WORD_BALL;
        } else if (strikeCount > 0) {
            return strikeCount + MessageUtil.WORD_STRIKE;
        }
        return "";
    }
}
