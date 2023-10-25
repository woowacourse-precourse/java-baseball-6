package baseball.model;

import baseball.constant.ExceptionMessage;
import java.util.List;

public class Numbers {
    private static final int NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_SIZE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> 1 > number || 9 < number)
                .findAny()
                .ifPresent(number ->
                {
                    throw new IllegalArgumentException(ExceptionMessage.NUMBERS_RANGE);
                });
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctNumberSize = numbers.stream()
                .distinct()
                .count();
        if (distinctNumberSize != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_DUPLICATE);
        }
    }

    public long countMatching(Numbers target) {
        int index = 0;
        long count = 0;
        for (Integer number : this.numbers) {
            Integer targetNumber = target.numbers.get(index++);
            if (number.equals(targetNumber)) {
                count++;
            }
        }
        return count;
    }

    public long countContains(Numbers target) {
        return this.numbers.stream()
                .filter(number -> target.numbers.contains(number))
                .count();
    }


}
