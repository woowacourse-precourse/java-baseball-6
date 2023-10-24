package baseball.player;

import baseball.util.Numbers;
import baseball.util.Result;

public sealed class Player permits User, Computer {
    protected Numbers numbers;

    public Player() {
        this.numbers = new Numbers();
    }

    public void createNumbers() {
    }

    public Result compareWith(Player other) {
        return this.numbers.compareWith(other.numbers);
    }
}
