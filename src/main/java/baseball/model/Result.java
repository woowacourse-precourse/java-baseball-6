package baseball.model;

import static baseball.config.Config.NUMBER_LENGTH;

import baseball.view.OutputView;

public class Result {

    private int ballCount;
    private int strikeCount;

    private Result(final Number playerNumber, final Number computerNumber) {
        ballCount = playerNumber.countBallCount(computerNumber);
        strikeCount = playerNumber.countStrikeCount(computerNumber);
    }

    public static Result create(final Number playerNumber, final Number computerNumber) {
        return new Result(playerNumber, computerNumber);
    }

    public void print() {
        if (strikeCount == 0 && ballCount == 0) {
            OutputView.printNothing();
        }
        if (ballCount > 0) {
            OutputView.printBall(ballCount);
        }
        if (strikeCount > 0) {
            OutputView.printStrike(strikeCount);
        }
        OutputView.printEmptyLine();
    }

    public boolean checkGameOver() {
        return strikeCount == NUMBER_LENGTH;
    }
}
