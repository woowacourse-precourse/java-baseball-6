package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class BallNumbers {

    public static final int BALL_NUMBERS_SIZE = 3;

    private final List<BallNumber> ballNumbers;

    public BallNumbers(final List<Integer> numbers) {
        validate(numbers);
        ballNumbers = mapBallNumbers(numbers);
    }

    private List<BallNumber> mapBallNumbers(final List<Integer> numbers) {
        final List<BallNumber> ballNumbers = new ArrayList<>();

        for (int i = 0; i < BALL_NUMBERS_SIZE; i++) {
            ballNumbers.add(new BallNumber(numbers.get(i), i));
        }
        return ballNumbers;
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

    public PlayResult compareAll(final BallNumbers other) {
        return new PlayResult(mapCompareResults(other));
    }

    private List<CompareResult> mapCompareResults(final BallNumbers other) {
        return ballNumbers.stream()
                .map(other::compare)
                .collect(Collectors.toList());
    }

    private CompareResult compare(final BallNumber other) {
        return ballNumbers.stream()
                .map(ballNumber -> ballNumber.compare(other))
                .filter(result -> !result.isNothing())
                .findFirst()
                .orElse(CompareResult.NOTHING);
    }
}
