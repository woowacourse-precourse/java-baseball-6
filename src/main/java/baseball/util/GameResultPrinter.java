package baseball.util;

import static baseball.util.MessageFormatter.*;

import baseball.dto.response.StrikeBallResponse;

public class GameResultPrinter {

    public String printOtherResult(StrikeBallResponse response) {

        if (response.hasBallStrike()) {
            return handleBallStrike(response.getBallCount(), response.getStrikeCount());
        }
        if (response.hasStrike()) {
            return handleStrike(response.getStrikeCount());
        }
        if (response.hasBall()) {
            return handleBall(response.getBallCount());
        }
        return handelNothing();
    }

    public void handleGameExit() {
        System.out.println(CURRENT_GAME_CLOSE);
    }

    public void printThreeStrike(int strike) {
        System.out.println(MessageFormatter.formatStrikeMessage(strike));
        System.out.println(THREE_STRIKE);
    }

    private String handelNothing() {
        return NOTHING_MESSAGE;
    }

    private String handleBallStrike(int ball, int strike) {
        return MessageFormatter.formatBallStrikeMessage(ball, strike);
    }

    private String handleStrike(int strike) {
        return MessageFormatter.formatStrikeMessage(strike);
    }

    private String handleBall(int ball) {
        return MessageFormatter.formatBallMessage(ball);
    }
}
