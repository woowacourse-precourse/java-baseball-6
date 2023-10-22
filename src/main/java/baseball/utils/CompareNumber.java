package baseball.utils;

import java.util.List;

public class CompareNumber {
    private int ball;
    private int strike;

    public int[] getCompareNumberResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        resetCount();
        strikeCount(computerNumbers, playerNumbers);
        ballCount(computerNumbers, playerNumbers);
        ballExceptStrike();

        return new int[]{ball, strike};
    }

    public boolean isCorrect() {
        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    private void resetCount() {
        ball = 0;
        strike = 0;
    }

    private void strikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
            }
        }
    }

    private void ballCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (Integer number : playerNumbers) {
            if (computerNumbers.contains(number)) {
                ball++;
            }
        }
    }

    public void ballExceptStrike() {
        ball = ball - strike;
    }
}
