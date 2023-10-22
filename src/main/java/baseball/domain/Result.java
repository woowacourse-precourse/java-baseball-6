package baseball.domain;

import baseball.view.OutputView;

public class Result {
    private static final int NUMBER_LENGTH = 3;

    private final int ballCount;
    private final int strikeCount;

    private Result(final Number playerNumber, final Number computerNumber) {
        ballCount = playerNumber.countBallCount(computerNumber);
        strikeCount = playerNumber.countStrikeCount(computerNumber);
    }

    public static Result create(final Number playerNumber, final Number computerNumber) {
        return new Result(playerNumber, computerNumber);
    }

    public void print() {
        if (ballCount == 0 && strikeCount == 0) {
            OutputView.printNothing();
        } else if (ballCount > 0 && strikeCount > 0) {
            OutputView.printBallAndStrikeCount(ballCount, strikeCount);
        } else if (ballCount > 0) {
            OutputView.printBallCount(ballCount);
        } else if (strikeCount > 0) {
            OutputView.printStrikeCount(strikeCount);
        }
    }

    public boolean checkGameOver() {
        return strikeCount == NUMBER_LENGTH;
    }
}
