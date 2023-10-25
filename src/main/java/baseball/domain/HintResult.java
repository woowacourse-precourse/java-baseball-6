package baseball.domain;

public class HintResult {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    private final Hint hint;

    public HintResult(Hint hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int strikeCount = hint.getStrikeCount();
        int ballCount = hint.getBallCount();

        appendStrikeAndBall(result, strikeCount, ballCount);

        return result.toString();
    }

    private void appendStrikeAndBall(StringBuilder result, int strikeCount, int ballCount) {
        if (hint.isBallCountBiggerThanZero()) {
            result.append(ballCount).append(BALL);
        }

        if (hint.isStrikeCountBiggerThanZero()) {
            if (hint.isBallCountBiggerThanZero()) {
                result.append(" ");
            }
            result.append(strikeCount).append(STRIKE);
        }

        if (hint.isStrikeCountZero() && hint.isBallCountZero()) {
            result.append(NOTHING);
        }
    }
}
