package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
        final HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Ball> mapBallNumbers(final List<Integer> numbers) {
        final List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < BALL_NUMBERS_SIZE; i++) {
            balls.add(new Ball(numbers.get(i), i));
        }
        return balls;
    }

    public PlayResult compareAll(final Balls other) {
        return new PlayResult(mapCompareResults(other));
    }

    private List<CompareResult> mapCompareResults(final Balls other) {
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
