package baseball.domain.game;

import java.util.List;

public final class Player extends GameNumbers {
    private Player(List<Integer> numbers) {
        super(numbers);
    }

    public static Player of(List<Integer> numbers) {
        return new Player(numbers);
    }
}
