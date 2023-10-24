package baseball.player;

public sealed class Player permits User, Computer {
    protected Number number;

    public void createNumber() {
    }

    public void validateNumber() {
    }
}
