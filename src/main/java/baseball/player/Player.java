package baseball.player;

import baseball.util.Numbers;

public sealed class Player permits User, Computer {
    protected Numbers numbers;

    public void createNumbers() {
    }
}
