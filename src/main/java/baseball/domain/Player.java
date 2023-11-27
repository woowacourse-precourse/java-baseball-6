package baseball.domain;

import java.util.List;

public class Player {

    private static final int VALID_NUMBER_LENGTH = 3;
    private static final int INVALID_NUMBER = 0;
    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int getNumberAt(int index) {
        return numbers.get(index);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.contains(INVALID_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != VALID_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() > VALID_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
