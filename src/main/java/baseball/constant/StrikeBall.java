package baseball.constant;

public enum StrikeBall {
    STRIKE("스트라이크"),
    BALL("볼"),
    NONE("");

    private final String name;

    StrikeBall(final String name) {
        this.name = name;
    }
}
