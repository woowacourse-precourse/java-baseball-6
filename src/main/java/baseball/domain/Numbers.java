package baseball.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Numbers {

    protected static final int NUMBER_LENGTH = 3;

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> createCompareResult(final Numbers inputNumbers) {
        int strikeCount = calculateStrikeCount(inputNumbers);
        int ballCount = calculateBallCount(inputNumbers);
        return List.of(strikeCount, ballCount);
    }

    private int calculateStrikeCount(final Numbers inputNumbers) {
        return (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> isStrike(numbers.get(i), inputNumbers.numbers.get(i)))
                .count();
    }

    private int calculateBallCount(final Numbers inputNumbers) {
        return (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> isBall(numbers.get(i), inputNumbers.numbers.get(i)))
                .count();
    }

    private boolean isStrike(final int computerNumber, final int inputNumber) {
        return Objects.equals(computerNumber, inputNumber);
    }

    private boolean isBall(final int computerNumber, final int inputNumber) {
        return !isStrike(computerNumber, inputNumber) && numbers.contains(inputNumber);
    }
}
