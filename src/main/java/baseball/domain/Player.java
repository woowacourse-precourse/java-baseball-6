package baseball.domain;

import java.util.List;

public class Player {

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
        if (numbers.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() > 3) {
            throw new IllegalArgumentException();
        }
    }
}
