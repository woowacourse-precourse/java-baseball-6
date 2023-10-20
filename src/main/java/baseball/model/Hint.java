package baseball.model;

import static baseball.config.Config.NUMBER_LENGTH;

import baseball.view.OutputView;

public class Hint {

    private int ballCount;
    private int strikeCount;

    public void updateHint(final Number playerNumber, final Number computerNumber) {
        this.ballCount = playerNumber.countBallCount(computerNumber);
        this.strikeCount = playerNumber.countStrikeCount(computerNumber);
    }

    public boolean checkClear() {
        return strikeCount == NUMBER_LENGTH;
    }

    public void printHint() {
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
}
