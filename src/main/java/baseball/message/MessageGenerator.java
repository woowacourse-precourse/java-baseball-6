package baseball.message;

import baseball.counter.StrikeBallCount;

import static baseball.message.Messages.BALL;
import static baseball.message.Messages.RESULT_3_STRIKE;
import static baseball.message.Messages.RESULT_NOTHING;
import static baseball.message.Messages.STRIKE;

public class MessageGenerator {
    public static String generateGameResultMessage(StrikeBallCount countStrikeAndBall) {
        int strike = countStrikeAndBall.strike();
        int ball = countStrikeAndBall.ball();

        if (strike == 0 && ball == 0) {
            return RESULT_NOTHING;
        }

        if (strike == 3) {
            return RESULT_3_STRIKE;
        }

        StringBuilder message = new StringBuilder();

        if (ball > 0) {
            message.append(ball).append(BALL);
        }

        if (strike > 0) {
            if (ball > 0) {
                message.append(" ");
            }
            message.append(strike).append(STRIKE);
        }

        return message.toString();
    }
}
