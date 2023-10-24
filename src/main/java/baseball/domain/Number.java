package baseball.domain;

import baseball.validation.NumberDuplicateValidator;
import baseball.validation.NumberRangeValidator;
import baseball.validation.NumberSizeValidator;
import java.util.List;

public class Number {
    private final List<Integer> numbers;

    public Number(List<Integer> numbers) {
        NumberRangeValidator.validate(numbers);
        NumberDuplicateValidator.validate(numbers);
        NumberSizeValidator.validate(numbers);
        this.numbers = numbers;
    }

    public boolean isContainNumber(Number other, int index) {
        return numbers.contains(other.getNumberAt(index));
    }

    public boolean isSamePosition(Number other, int index) {
        return numbers.get(index).equals(other.getNumberAt(index));
    }

    public int size() {
        return numbers.size();
    }

    private Integer getNumberAt(int index) {
        return numbers.get(index);
    }
}