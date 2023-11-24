package baseball.model;

import java.util.List;

public class Player {

    private static final int NUMBERS_SIZE = 3;
    private static final String DUPLICATE_EX_MESSAGE = "서로 다른 숫자여야 합니다.";
    private static final String SIZE_EX_MESSAGE = "%d자리 숫자여야 합니다.";
    private static final String RANGE_EX_MESSAGE = "1~9 사이의 숫자여야 합니다.";

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
            throw new IllegalArgumentException(DUPLICATE_EX_MESSAGE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(SIZE_EX_MESSAGE, NUMBERS_SIZE));
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException(RANGE_EX_MESSAGE);
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public boolean hasSamePlace(int number, int place) {
        return numbers.get(place) == number;
    }
}
