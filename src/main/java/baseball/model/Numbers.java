package baseball.model;

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
            throw new IllegalArgumentException("숫자는 3개를 가져야 합니다");
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> 1 > number || 9 < number)
                .findAny()
                .ifPresent(number ->
                {
                    throw new IllegalArgumentException("숫자는 1부터 9까지의 수로 이루어져야 합니다");
                });
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctNumberSize = numbers.stream()
                .distinct()
                .count();
        if (distinctNumberSize != NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자는 서로 다른 수로 이루어져 있어야 한다");
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
