package baseball.util;

import baseball.constants.MessageConstants;
import baseball.constants.NumberConstants;
import baseball.constants.StringConstants;

public class CountsMessage {

    private static StringBuilder messageBuilder;

    public static String toMessage(int ball, int strike) {
        if (isZero(ball) && isZero(strike)) {
            return MessageConstants.NOTHING_MESSAGE;
        }
        messageBuilder = new StringBuilder();

        buildBallMessage(ball);
        buildStrikeMessage(strike);

        return messageBuilder.toString();
    }

    private static void buildBallMessage(int ball) {
        if (!isZero(ball)) {
            messageBuilder.append(ball)
                    .append(MessageConstants.BALL_MESSAGE);
        }
    }

    private static void buildStrikeMessage(int strike) {
        if (isZero(strike)) {
            return;
        }
        if (!messageBuilder.isEmpty()) {
            messageBuilder.append(StringConstants.SPACE);
        }
        if (!isZero(strike)) {
            messageBuilder.append(strike)
                    .append(MessageConstants.STRIKE_MESSAGE);
        }
    }

    private static boolean isZero(int number) {
        return number == NumberConstants.ZERO;
    }
}
