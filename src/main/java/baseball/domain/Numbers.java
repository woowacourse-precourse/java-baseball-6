package baseball.domain;

import java.util.List;

public final class Numbers {

    private static final int NUMBER_LIST_SIZE = 3;
    private final List<Number> numbers;

    public Numbers(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().map(Number::new).toList();
    }

    private void validate(final List<Integer> numbers) {
        if (isProperSize(numbers)) {
            throw new IllegalStateException();
        }
    }

    private boolean isProperSize(final List<Integer> numbers) {
        return numbers.size() != NUMBER_LIST_SIZE;
    }
}
