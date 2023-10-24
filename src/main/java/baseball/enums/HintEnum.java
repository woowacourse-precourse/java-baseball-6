package baseball.enums;

public enum HintEnum {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String value;

    HintEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
