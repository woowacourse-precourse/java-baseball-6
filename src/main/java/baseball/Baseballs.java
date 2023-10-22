package baseball;

import java.util.List;

public class Baseballs {
    private final List<Baseball> baseballs;

    public Baseballs(final List<Integer> numbers) {
        validate(numbers);
        this.baseballs = null;
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateValue(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalStateException("3자리 수가 아닙니다.");
        }
    }

    private void validateValue(final List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (distinctCount != 3) {
            throw new IllegalStateException("3개의 수가 서로 다르지 않습니다.");
        }
    }
}
