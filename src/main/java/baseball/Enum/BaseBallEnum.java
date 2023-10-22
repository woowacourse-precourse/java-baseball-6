package baseball.Enum;

public enum BaseBallEnum {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String description;

    BaseBallEnum(String description) {
        this.description = description;
    }
}
