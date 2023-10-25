package baseball.model;

import java.util.List;

public class Computer {

    private final Balls balls;

    public Computer(final List<Integer> numbers) {
        this.balls = new Balls(numbers);
    }

    public PlayResult compute(final Balls playerBalls) {
        return PlayResult.from(balls.compareAll(playerBalls));
    }
}
