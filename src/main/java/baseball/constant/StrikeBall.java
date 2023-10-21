package baseball.constant;

public enum StrikeBall {
    STRIKE("스트라이크"),
    BALL("볼"),
    NONE("");

    private final String name;

    StrikeBall(final String name) {
        this.name = name;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
