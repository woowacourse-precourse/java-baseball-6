package baseball.view;

import baseball.constant.OutputMessage;
import baseball.model.dto.BaseballGameResult;

public class OutputConverter {

    private static final int NO_COUNT = 0;
    private static final int THREE_STRIKE = 3;

    public String convertMessage(final BaseballGameResult baseballGameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        if (isBall(baseballGameResult)) {
            appendBall(stringBuilder, baseballGameResult.getBallCount());
        }
        if (isStrike(baseballGameResult)) {
            appendStrike(stringBuilder, baseballGameResult.getStrikeCount());
        }
        if (isNoBallAndNoStrike(baseballGameResult)) {
            appendNoBallAndNoStrike(stringBuilder);
        }
        if (isThreeStikre(baseballGameResult)) {
            appendGameOver(stringBuilder);
        }

        return stringBuilder.toString();
    }

    private boolean isBall(final BaseballGameResult baseballGameResult) {
        return baseballGameResult.getBallCount() != NO_COUNT;
    }

    private boolean isStrike(final BaseballGameResult baseballGameResult) {
        return baseballGameResult.getStrikeCount() != NO_COUNT;
    }

    private boolean isNoBallAndNoStrike(final BaseballGameResult baseballGameResult) {
        return baseballGameResult.getBallCount() == NO_COUNT && baseballGameResult.getStrikeCount() == NO_COUNT;
    }

    private boolean isThreeStikre(final BaseballGameResult baseballGameResult) {
        return baseballGameResult.getStrikeCount() == THREE_STRIKE;
    }

    private void appendBall(final StringBuilder stringBuilder, final int ballCount) {
        stringBuilder.append(ballCount);
        stringBuilder.append(OutputMessage.BALL);
        stringBuilder.append(OutputMessage.SPACE);
    }

    private void appendStrike(final StringBuilder stringBuilder, final int strikeCount) {
        stringBuilder.append(strikeCount);
        stringBuilder.append(OutputMessage.STRIKE);
    }

    private void appendNoBallAndNoStrike(final StringBuilder stringBuilder) {
        stringBuilder.append(OutputMessage.NOTHING);
        stringBuilder.append(OutputMessage.SPACE);
    }

    private void appendGameOver(final StringBuilder stringBuilder) {
        stringBuilder.append(OutputMessage.LINE_BREAK);
        stringBuilder.append(OutputMessage.THREE_STRIKE_MESSAGE);
    }
}
