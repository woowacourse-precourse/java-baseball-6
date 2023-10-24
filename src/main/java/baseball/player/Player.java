package baseball.player;

import baseball.util.Numbers;

public sealed class Player permits User, Computer {
    protected Numbers numbers;

    public Player() {
        this.numbers = new Numbers();
    }

    public void createNumbers() {
    }
}
