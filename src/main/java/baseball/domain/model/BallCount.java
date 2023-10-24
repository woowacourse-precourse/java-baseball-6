package baseball.domain.model;

public enum BallCount {
    OUT("아웃"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String value;

    BallCount(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
