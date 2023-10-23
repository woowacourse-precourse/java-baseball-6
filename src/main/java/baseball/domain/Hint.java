package baseball.domain;

public enum Hint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String hint;

    Hint(String hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        return hint;
    }
}
