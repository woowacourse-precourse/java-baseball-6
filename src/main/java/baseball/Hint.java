package baseball;

import static baseball.Config.NUMBER_LENGTH;

public class Hint {

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    private int strikeCount;
    private int ballCount;

    public Hint updateHint(final String playerNumber, final String computerNumber) {
        this.ballCount = 0;
        this.strikeCount = 0;
        countBallCount(playerNumber, computerNumber);
        countStrikeCount(playerNumber, computerNumber);
        return this;
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

            if (playerDigit != computerDigit && computerNumber.contains(
                String.valueOf(playerDigit))) {
                this.ballCount++;
            }
        }
    }
}
