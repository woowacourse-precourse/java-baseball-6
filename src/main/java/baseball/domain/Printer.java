package baseball.domain;

import static baseball.domain.MessageConstants.END_MESSAGE;
import static baseball.domain.MessageConstants.INPUT_MESSAGE;
import static baseball.domain.MessageConstants.NOTHING_MESSAGE;
import static baseball.domain.MessageConstants.ONLY_BALL_MESSAGE_FORMAT;
import static baseball.domain.MessageConstants.ONLY_STRIKE_MESSAGE_FORMAT;
import static baseball.domain.MessageConstants.START_MESSAGE;
import static baseball.domain.MessageConstants.STRIKE_BALL_MESSAGE_FORMAT;

class Printer {
    Printer() {
    }

    void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    void printResult(StrikeBallCount strikeBallCount) {
        int strikeCount = strikeBallCount.strike();
        int ballCount = strikeBallCount.ball();

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (ballCount == 0) {
            System.out.printf((ONLY_STRIKE_MESSAGE_FORMAT) + "%n", strikeCount);
            return;
        }
        if (strikeCount == 0) {
            System.out.printf((ONLY_BALL_MESSAGE_FORMAT) + "%n", ballCount);
            return;
        }
        System.out.printf((STRIKE_BALL_MESSAGE_FORMAT) + "%n", strikeCount, ballCount);
    }

    void printEndMessage() {
        System.out.println(END_MESSAGE);
    }
}
