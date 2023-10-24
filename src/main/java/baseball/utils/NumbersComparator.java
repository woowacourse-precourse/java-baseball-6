package baseball.utils;

import static baseball.model.constants.Rule.GAME_NUMBERS_SIZE;
import static baseball.model.constants.Rule.GAME_WIN;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumbersComparator {
    private final List<Integer> result = new ArrayList<>();
    private int strike;
    private int ball;

    public List<Integer> getCompareNumberResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        resetCount();
        calculateStrike(computerNumbers, playerNumbers);
        calculateBall(computerNumbers, playerNumbers);
        setHint();
        return result;
    }

    public boolean isCorrect() {
        return result.get(1) == GAME_WIN.getValue();
    }

    private void resetCount() {
        result.clear();
        result.add(0);
        result.add(0);
    }

    private void calculateStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        strike = (int) IntStream.range(0, GAME_NUMBERS_SIZE.getValue())
                .filter(i -> playerNumbers.get(i).equals(computerNumbers.get(i)))
                .count();
    }

    private void calculateBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        ball = (int) playerNumbers.stream().filter(computerNumbers::contains).count() - strike;
    }

    private void setHint() {
        result.set(0, ball);
        result.set(1, strike);
    }
}
