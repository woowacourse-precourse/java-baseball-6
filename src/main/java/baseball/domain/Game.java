package baseball.domain;

import baseball.util.Constants;
import java.util.List;

public class Game {

    private int strike;
    private int ball;

    public Game() {
        this.strike = 0;
        this.ball = 0;
    }

    public void compareNumbers(List<Integer> computerNumber, List<Integer> playerNumber) {
        strike = countStrikes(computerNumber, playerNumber);
        ball = countBalls(computerNumber, playerNumber);
    }

    public int getStrikes() {
        return strike;
    }

    public int getBalls() {
        return ball;
    }

    public int countStrikes(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strikes = 0;
        for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
            int computerDigit = computerNumber.get(i);
            int playerDigit = playerNumber.get(i);

            if (computerDigit == playerDigit) {
                strikes++;
            }
        }
        return strikes;
    }

    public int countBalls(List<Integer> computerNumber, List<Integer> playerNumber) {
        int balls = 0;
        for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
            int computerDigit = computerNumber.get(i);
            int playerDigit = playerNumber.get(i);

            if (computerDigit != playerDigit && computerNumber.contains(playerDigit)) {
                balls++;
            }
        }
        return balls;
    }
}
