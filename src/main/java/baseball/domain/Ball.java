package baseball.domain;

public enum Ball {
    ZERO(""),
    ONE("1볼"),
    TWO("2볼"),
    THREE("3볼");

    private final String description;

    Ball(String description) {
        this.description = description;
    }

    public static Ball fromInt(int value) {
        return values()[value];
    }

    @Override
    public String toString() {
        return description;
    }
}
