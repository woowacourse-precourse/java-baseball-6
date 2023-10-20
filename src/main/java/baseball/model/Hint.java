package baseball.model;

import static baseball.config.Config.NUMBER_LENGTH;
import static java.lang.String.valueOf;

import baseball.view.OutputView;

public class Hint {

    private int ballCount;
    private int strikeCount;

    public void reset() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void updateHint(final String playerNumber, final String computerNumber) {
        countStrikeCount(playerNumber, computerNumber);
        countBallCount(playerNumber, computerNumber);
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

    private void countStrikeCount(final String playerNumber, final String computerNumber) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (playerNumber.charAt(i) == computerNumber.charAt(i)) {
                this.strikeCount++;
            }
        }
    }

    private void countBallCount(final String playerNumber, final String computerNumber) {
        for (int i = 0; i < playerNumber.length(); i++) {
            char playerDigit = playerNumber.charAt(i);
            char computerDigit = computerNumber.charAt(i);

            if (playerDigit != computerDigit && computerNumber.contains(valueOf(playerDigit))) {
                this.ballCount++;
            }
        }
    }
}
