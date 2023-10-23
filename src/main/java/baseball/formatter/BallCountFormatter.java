package baseball.formatter;

import baseball.constant.BallCountMessage;
import baseball.domain.BallCount;

public class BallCountFormatter {

    private static final long NONE = 0L;
    private static final String BLANK_DELIMITER = " ";

    public String format(final BallCount ballCount) {
        final long ballNum = ballCount.countBall();
        final long strikeNum = ballCount.countStrike();

        return getFormattedOutput(ballNum, strikeNum);
    }

    private String getFormattedOutput(final long ballNum, final long strikeNum) {
        if (ballNum == NONE && strikeNum == NONE) {
            return BallCountMessage.NOTHING.toValue();
        }
        return toCountResult(ballNum, strikeNum);
    }

    private String toCountResult(final long ballNum, final long strikeNum) {
        final StringBuilder stringBuilder = new StringBuilder();
        if (ballNum != NONE) {
            stringBuilder
                    .append(String.format(BallCountMessage.BALL.toValue(), ballNum))
                    .append(BLANK_DELIMITER);
        }
        return appendStrikeIfExists(stringBuilder, strikeNum);
    }

    private String appendStrikeIfExists(final StringBuilder stringBuilder, final long strikeNum) {
        if (strikeNum != NONE) {
            stringBuilder.append(String.format(BallCountMessage.STRIKE.toValue(), strikeNum));
        }
        return stringBuilder.toString();
    }
}
