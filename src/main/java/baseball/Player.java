package baseball;

import java.util.List;

public class Player {

    private final Balls balls;

    public Player(final List<Integer> balls) {
        this.balls = new Balls(balls);
    }

    public PlayResult play(final Computer computer) {
        return computer.compute(balls);
    }
}
