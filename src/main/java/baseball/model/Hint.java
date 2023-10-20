package baseball.model;

import static baseball.config.Config.NUMBER_LENGTH;

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

    public boolean checkClear(){
        return strikeCount == NUMBER_LENGTH;
    }

    public void printHint() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.println();
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
