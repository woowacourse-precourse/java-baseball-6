package baseball.domain;

/**
 * 피칭 결과에 대한 ENUM
 */
public enum Sign {
    NOTHING("낫싱"), STRIKE("스트라이크"), BALL("볼");

    private final String value;

    Sign(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
