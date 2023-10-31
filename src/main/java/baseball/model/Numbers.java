package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Numbers {
    public static final int SIZE = 3;
    public static final int START_INDEX = 0;
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validateSize(numbers);
        validateNoDuplicates(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Numbers from(String numbers) {
        return new Numbers(IntStream.range(START_INDEX, numbers.length())
                .map(numbers::charAt)
                .map(Character::getNumericValue)
                .mapToObj(Number::new)
                .toList());
    }

    private void validateSize(List<Number> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicates(List<Number> numbers) {
        Set<Number> numberSet = new HashSet<>(numbers);
        if (numberSet.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int countBall(Numbers other) {
        List<Number> otherNumbers = other.numbers;
        return (int) IntStream.range(START_INDEX, SIZE)
                .filter(index -> {
                    Number number = numbers.get(index);
                    Number otherNumber = otherNumbers.get(index);
                    return !number.equals(otherNumber) && numbers.contains(otherNumber);
                }).count();
    }

    public int countStrike(Numbers other) {
        List<Number> otherNumbers = other.numbers;
        return (int) IntStream.range(START_INDEX, SIZE)
                .filter(index -> {
                    Number number = numbers.get(index);
                    Number otherNumber = otherNumbers.get(index);
                    return number.equals(otherNumber);
                }).count();
    }
}
