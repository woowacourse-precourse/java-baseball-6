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

    public int getStrikeCount(final List<Integer> userNumbers) {
        return (int) IntStream.range(FIRST_NUMBER, userNumbers.size())
            .filter(index -> isStrike(index, userNumbers))
            .count();
    }

    private boolean isStrike(final int index, final List<Integer> userNumbers) {
        return numbers.get(index).equals(userNumbers.get(index));
    }

    public int getBallCount(final List<Integer> userNumbers) {
        return (int) IntStream.range(FIRST_NUMBER, userNumbers.size())
            .filter(index -> isBall(index, userNumbers))
            .count();
    }

    private boolean isBall(final int index, final List<Integer> userNumbers) {
        int number = userNumbers.get(index);
        return !numbers.get(index).equals(number) && numbers.contains(number);
    }
}

