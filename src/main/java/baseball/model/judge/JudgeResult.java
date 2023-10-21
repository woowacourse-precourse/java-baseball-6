package baseball.model.judge;

import baseball.util.StringConstant;

public class JudgeResult {

    private static final String STRIKE_TEXT = "스트라이크";
    private static final String BALL_TEXT = "볼";
    private static final String NOTHING_TEXT = "낫싱";

    private final BallCount ballCount;
    private final StrikeCount strikeCount;
    private final boolean isNothing;

    private JudgeResult(BallCount ballCount, StrikeCount strikeCount, boolean isNothing) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.isNothing = isNothing;
    }

    public static JudgeResult createBallStrikeResult(BallCount ballCount, StrikeCount strikeCount) {
        return new JudgeResult(ballCount, strikeCount, false);
    }

    public static JudgeResult createNothingResult() {
        return new JudgeResult(BallCount.noCount(), StrikeCount.noCount(), true);
    }

    public String toResultString() {
        if (this.isNothing) {
            return NOTHING_TEXT;
        }
        return toBallCountString() + System.lineSeparator() + toStrikeCountString();
    }

    private String toBallCountString() {
        if (this.ballCount.isZero()) {
            return StringConstant.EMPTY_STRING;
        }
        return ballCount + BALL_TEXT;
    }

    private String toStrikeCountString() {
        if (this.strikeCount.isZero()) {
            return StringConstant.EMPTY_STRING;
        }
        return strikeCount + STRIKE_TEXT;
    }

}
