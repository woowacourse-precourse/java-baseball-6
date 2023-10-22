package baseball.domain;

import java.util.List;

public final class Numbers {

    private static final int NUMBER_LIST_SIZE = 3;
    private final List<Number> values;

    public Numbers(final List<Integer> values) {
        validate(values);
        this.values = values.stream().map(Number::new).toList();
    }

    private void validate(final List<Integer> numbers) {
        if (hasInvalidSize(numbers) || isNotUnique(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotUnique(final List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean hasInvalidSize(final List<Integer> numbers) {
        return numbers.size() != NUMBER_LIST_SIZE;
    }

    public Number getByIndex(final int index) {
        return new Number(values.get(index));
    }

    public boolean contains(final Number number) {
        return values.contains(number);
    }

    public boolean hasSameIndexAndValue(final Number number, final int index) {
        return values.get(index).equals(number);
    }
}
