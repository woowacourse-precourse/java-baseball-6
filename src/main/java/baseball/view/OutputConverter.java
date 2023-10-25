package baseball.view;

import baseball.constant.OutputMessage;
import baseball.model.dto.BaseballGameResult;

public class OutputConverter {

    private static final int NO_COUNT = 0;
    private static final int THREE_STRIKE = 3;

    public String convertMessage(final BaseballGameResult baseballGameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        appendBall(stringBuilder, baseballGameResult);
        appendStrike(stringBuilder, baseballGameResult);
        appendNoBallAndNoStrike(stringBuilder, baseballGameResult);
        appendGameOver(stringBuilder, baseballGameResult);

        return stringBuilder.toString();
    }

    private void appendBall(final StringBuilder stringBuilder, final BaseballGameResult baseballGameResult) {
        if (isBall(baseballGameResult)) {
            stringBuilder.append(baseballGameResult.getBallCount());
            stringBuilder.append(OutputMessage.BALL);
            stringBuilder.append(OutputMessage.SPACE);
        }
    }

    private void appendStrike(final StringBuilder stringBuilder, final BaseballGameResult baseballGameResult) {
        if (isStrike(baseballGameResult)) {
            stringBuilder.append(baseballGameResult.getStrikeCount());
            stringBuilder.append(OutputMessage.STRIKE);
        }
    }

    private void appendNoBallAndNoStrike(final StringBuilder stringBuilder,
                                         final BaseballGameResult baseballGameResult) {
        if (isNoBallAndNoStrike(baseballGameResult)) {
            stringBuilder.append(OutputMessage.NOTHING);
            stringBuilder.append(OutputMessage.SPACE);
        }
    }

    private void appendGameOver(final StringBuilder stringBuilder, final BaseballGameResult baseballGameResult) {
        if (isThreeStikre(baseballGameResult)) {
            stringBuilder.append(OutputMessage.LINE_BREAK);
            stringBuilder.append(OutputMessage.THREE_STRIKE_MESSAGE);
        }
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
}
