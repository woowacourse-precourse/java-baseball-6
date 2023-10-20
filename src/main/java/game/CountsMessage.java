package game;

import constants.MessageConstants;
import constants.NumberConstants;
import constants.StringConstants;

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
        if (!messageBuilder.isEmpty()) {
            messageBuilder.append(StringConstants.BLANK);
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
