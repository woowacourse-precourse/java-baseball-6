package baseball.player;

import baseball.number.Numbers;
import baseball.result.Result;

public sealed class Player permits User, Computer {
    protected Numbers numbers;

    public void createNumbers() {
    }

    public Result compareWith(Player other) {
        return numbers.compareWith(other.numbers);
    }
}
