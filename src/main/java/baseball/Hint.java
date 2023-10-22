package baseball;

import java.util.List;

public class Hint {

    private int strike = 0;
    private int ball = 0;

    private Hint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        countStrikeAndBall(computerNumbers, playerNumbers);
    }

    public static Hint of(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        return new Hint(computerNumbers, playerNumbers);
    }

    public boolean isThreeStrike() {
        return strike == Constant.GAME_WIN;
    }

    public String getHint() {
        String hintMessage = "";
        if (isBallAndStrike(ball, strike)) {
            hintMessage = ball + Constant.BALL_MESSAGE + strike + Constant.STRIKE_MESSAGE;
        }
        if (isBall(ball, strike)) {
            hintMessage = ball + Constant.BALL_MESSAGE;
        }
        if (isStrike(ball, strike)) {
            hintMessage = strike + Constant.STRIKE_MESSAGE;
        }
        if (isNothing(ball, strike)) {
            hintMessage = Constant.NOTHING_MESSAGE;
        }
        return hintMessage;
    }

    private void countStrikeAndBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < Constant.NUMBERS_SIZE; i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
                continue;
            }

            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
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
}
