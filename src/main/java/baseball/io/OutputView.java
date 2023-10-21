package baseball.io;

import baseball.constant.GameMessage;
import baseball.domain.BallCount;
import baseball.formatter.BallCountFormatter;

public class OutputView {

    private final BallCountFormatter ballCountFormatter;

    public OutputView(final BallCountFormatter ballCountFormatter) {
        this.ballCountFormatter = ballCountFormatter;
    }

    public void printStartMessage() {
        System.out.println(GameMessage.GAME_START.toValue());
    }

    public void printNumberInputRequest() {
        System.out.print(GameMessage.NUMBER_INPUT_REQUEST.toValue());
    }

    public void printBallCount(final BallCount ballCount) {
        System.out.println(ballCountFormatter.format(ballCount));
    }
}
