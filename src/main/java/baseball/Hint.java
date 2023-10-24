package baseball;

import baseball.constants.Constants;
import java.util.List;

public class Hint {

    private int strike = 0;
    private int ball = 0;

    private Hint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        countStrikeAndBall(computerNumbers, playerNumbers);
    }

    public static Hint of(List<Integer> computerNumbers, Number playerNumbers) {
        return new Hint(computerNumbers, playerNumbers.getNumbers());
    }

    private void countStrikeAndBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < Constants.NUMBERS_SIZE; i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
                continue;
            }

            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
    }

    public boolean isThreeStrike() {
        return strike == Constants.GAME_WIN;
    }

    private boolean isBallAndStrike(int ball, int strike) {
        return (ball != 0) && (strike != 0);
    }

    private boolean isBall(int ball, int strike) {
        return (ball != 0) && (strike == 0);
    }

    private boolean isStrike(int ball, int strike) {
        return (ball == 0) && (strike != 0);
    }

    private boolean isNothing(int ball, int strike) {
        return (ball == 0) && (strike == 0);
    }

    public String getHint() {
        String hintMessage = "";
        if (isBallAndStrike(ball, strike)) {
            hintMessage = ball + Constants.BALL_MESSAGE + strike + Constants.STRIKE_MESSAGE;
        }
        if (isBall(ball, strike)) {
            hintMessage = ball + Constants.BALL_MESSAGE;
        }
        if (isStrike(ball, strike)) {
            hintMessage = strike + Constants.STRIKE_MESSAGE;
        }
        if (isNothing(ball, strike)) {
            hintMessage = Constants.NOTHING_MESSAGE;
        }
        return hintMessage;
    }
}
