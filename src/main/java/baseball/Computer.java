package baseball;

import java.util.List;

public class Computer {

    private final BallNumbers numbers;

    public Computer(final List<Integer> numbers) {
        this.numbers = new BallNumbers(numbers);
    }

    public PlayResult compute(final BallNumbers playerNumbers) {
        return numbers.compareAll(playerNumbers);
    }
}
