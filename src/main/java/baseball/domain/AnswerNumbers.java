package baseball.domain;

import baseball.constant.StrikeBall;

import java.util.List;

public final class AnswerNumbers {

    private final Numbers numbers;

    public AnswerNumbers(final List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public StrikeBall checkStrikeBall(final Number number, final int index) {
        if (numbers.contains(number)) {
            return checkIfStrike(number, index);
        }
        return StrikeBall.NONE;
    }

    private StrikeBall checkIfStrike(final Number number, final int index) {
        if (numbers.hasSameIndexAndValue(number, index)) {
            return StrikeBall.STRIKE;
        }
        return StrikeBall.BALL;
    }
}
