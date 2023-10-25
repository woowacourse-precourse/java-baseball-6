package baseball.constant;

public enum Hint {

    STRIKE("스트라이크 "),
    BALL("볼 ");

    private final String message;

    Hint(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
