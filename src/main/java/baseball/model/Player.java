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
        validateSize(numbers);
        validateRange(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        int uniqueNumberCount = (int) numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != uniqueNumberCount) {
            throw new IllegalArgumentException("서로 다른 숫자여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("1~9 사이의 숫자여야 합니다.");
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public boolean hasSamePlace(int number, int place) {
        return numbers.get(place) == number;
    }
}
