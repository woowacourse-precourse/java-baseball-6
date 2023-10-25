package baseball.model;

import java.util.List;

public class Computer {

    private final Balls balls;

    public Computer(final List<Integer> numbers) {
        this.balls = new Balls(numbers);
    }

    public PlayResult compute(final List<Integer> guessNumbers) {
        final Balls playerBalls = new Balls(guessNumbers);
        final CompareResults compareResults = balls.compareAll(playerBalls);
        return PlayResult.from(compareResults);
    }
}
