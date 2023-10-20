package baseball;

import java.util.List;

public class Player {

    private final BallNumbers numbers;

    public Player(final List<Integer> numbers) {
        this.numbers = new BallNumbers(numbers);
    }

    public PlayResult play(final Computer computer) {
        return computer.compute(numbers);
    }
}
