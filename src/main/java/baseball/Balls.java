package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {

    private static final int BALL_NUMBERS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(final List<Integer> numbers) {
        validate(numbers);
        balls = mapBallNumbers(numbers);
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != BALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Ball> mapBallNumbers(final List<Integer> numbers) {
        return IntStream.range(0, BALL_NUMBERS_SIZE)
                .mapToObj(i -> Ball.of(numbers.get(i), i))
                .toList();
    }

    public PlayResult compareAll(final Balls other) {
        return new PlayResult(mapResults(other));
    }

    private List<CompareResult> mapResults(final Balls other) {
        return balls.stream()
                .map(other::compare)
                .collect(Collectors.toList());
    }

    private CompareResult compare(final Ball other) {
        return balls.stream()
                .map(ball -> ball.compare(other))
                .filter(result -> !result.isNothing())
                .findFirst()
                .orElse(CompareResult.NOTHING);
    }
}
