package baseball;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(final List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public List<Integer> createCompareResult(final Numbers userNumbers) {
        int strikeCount = calculateStrikeCount(userNumbers);
        int ballCount = calculateBallCount(userNumbers);
        return List.of(strikeCount, ballCount);
    }

    private int calculateStrikeCount(final Numbers userNumbers) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> isSameNumber(numbers.get(i), userNumbers.numbers.get(i)))
                .count();
    }

    private int calculateBallCount(final Numbers userNumbers) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> !isSameNumber(numbers.get(i), userNumbers.numbers.get(i))
                        && numbers.contains(userNumbers.numbers.get(i)))
                .count();
    }

    private boolean isSameNumber(final int computerNumber, final int userNumber) {
        return Objects.equals(computerNumber, userNumber);
    }
}
