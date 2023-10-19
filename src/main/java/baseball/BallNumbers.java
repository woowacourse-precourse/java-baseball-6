package baseball;

import java.util.HashSet;
import java.util.List;

public class BallNumbers {

    public static final int BALL_NUMBERS_SIZE = 3;

    public BallNumbers(final List<Integer> numbers) {
        validate(numbers);
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

    public PlayResult compareAll(final BallNumbers player) {
        return new PlayResult();
    }
}
