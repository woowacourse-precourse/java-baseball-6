package baseball.domain.ball;

public enum Hint {
    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    BALL("볼");

    private final String value;

    Hint(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
