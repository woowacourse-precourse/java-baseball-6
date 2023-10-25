package baseball.domain;

import baseball.validation.NumberDuplicateValidator;
import baseball.validation.NumberRangeValidator;
import baseball.validation.NumberSizeValidator;
import java.util.List;
import java.util.stream.IntStream;

public class Number {
    private final List<Integer> numbers;

    public Number(List<Integer> numbers) {
        NumberRangeValidator.validate(numbers);
        NumberDuplicateValidator.validate(numbers);
        NumberSizeValidator.validate(numbers);
        this.numbers = numbers;
    }

    public int getSamePositionCount(Number other) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> numbers.get(i).equals(other.getNumberAt(i)))
                .count();
    }

    public int getContainNumberCount(Number other) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> numbers.contains(other.getNumberAt(i)))
                .filter(i -> !numbers.get(i).equals(other.getNumberAt(i)))
                .count();
    }

    private Integer getNumberAt(int index) {
        return numbers.get(index);
    }
}