package baseball.utils;

import static baseball.model.constants.Rule.GAME_NUMBERS_SIZE;
import static baseball.model.constants.Rule.GAME_WIN;

import java.util.List;
import java.util.stream.IntStream;

public class NumbersComparator {
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
        return strike == GAME_WIN.getValue();
    }

    private void resetCount() {
        ball = 0;
        strike = 0;
    }

    private void strikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        strike = (int) IntStream.range(0, GAME_NUMBERS_SIZE.getValue())
                .filter(i -> playerNumbers.get(i).equals(computerNumbers.get(i)))
                .count();

    }

    private void ballCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        ball = (int) playerNumbers.stream().filter(computerNumbers::contains).count();
    }

    private void ballExceptStrike() {
        ball = ball - strike;
    }
}
