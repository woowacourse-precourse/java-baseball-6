package baseball.domain;

public enum Strike {
    ZERO(""),
    ONE("1스트라이크"),
    TWO("2스트라이크"),
    THREE("3스트라이크");

    private final String description;

    Strike(String description) {
        this.description = description;
    }

    public static Strike fromInt(int value) {
        return values()[value];
    }

    @Override
    public String toString() {
        return description;
    }
}
