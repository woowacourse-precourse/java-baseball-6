package baseball.model;

import java.util.List;

public class Player {

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        int uniqueNumberCount = (int) numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != uniqueNumberCount) {
            throw new IllegalArgumentException("서로 다른 숫자여야 합니다.");
        }
    }
}
