package baseball.model;

import baseball.NumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class Computer {

    private static final int FIRST_NUMBER = 0;

    private final List<Integer> numbers;

    private Computer(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer createWithGenerator(final NumberGenerator generator) {
        return new Computer(generator.generate());
    }

    public int getStrikeCount(final List<Integer> inputNumbers) {
        return (int) IntStream.range(FIRST_NUMBER, inputNumbers.size())
            .filter(index -> isStrike(index, inputNumbers))
            .count();
    }

    private boolean isStrike(int index, List<Integer> inputNumbers) {
        return numbers.get(index).equals(inputNumbers.get(index));
    }
}

