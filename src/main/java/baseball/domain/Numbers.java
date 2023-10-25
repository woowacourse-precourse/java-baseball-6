package baseball.domain;

import baseball.constant.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.toValue());
        }
    }

    private boolean isNotUnique(final List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean hasInvalidSize(final List<Integer> numbers) {
        return numbers.size() != NUMBER_LIST_SIZE;
    }

    public Number valueAtIndex(final int index) {
        return new Number(values.get(index));
    }

    public boolean contains(final Number number) {
        return values.contains(number);
    }

    public boolean hasSameIndexAndValue(final Number number, final int index) {
        final Number value = values.get(index);
        return value.equals(number);
    }
}
