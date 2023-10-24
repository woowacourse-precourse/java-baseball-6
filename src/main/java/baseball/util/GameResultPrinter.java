package baseball.util;

import static baseball.util.MessageFormatter.CURRENT_GAME_CLOSE;
import static baseball.util.MessageFormatter.NOTHING_MESSAGE;
import static baseball.util.MessageFormatter.THREE_STRIKE;

import baseball.dto.response.StrikeBallResponse;

public class GameResultPrinter {

    public boolean printOtherResult(StrikeBallResponse response) {
        boolean hasStrike = response.hasStrike();
        boolean hasBall = response.hasBall();

        if (hasStrike && hasBall) {
            handleBallStrike(response.getBallCount(), response.getStrikeCount());
        } else if (hasStrike) {
            handleStrike(response.getStrikeCount());
        } else if (hasBall) {
            handleBall(response.getBallCount());
        } else {
            handelNothing();
        }
        return false;
    }

    public void handleGameExit() {
        System.out.println(CURRENT_GAME_CLOSE);
    }

    public void printThreeStrike(int strike) {
        System.out.println(MessageFormatter.formatStrikeMessage(strike));
        System.out.println(THREE_STRIKE);
    }

    private void handelNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    private void handleBallStrike(int ball, int strike) {
        System.out.println(MessageFormatter.formatBallStrikeMessage(ball, strike));
    }

    private void handleStrike(int strike) {
        System.out.println(MessageFormatter.formatStrikeMessage(strike));
    }

    private void handleBall(int ball) {
        System.out.println(MessageFormatter.formatBallMessage(ball));
    }
}
