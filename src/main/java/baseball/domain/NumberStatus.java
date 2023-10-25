package baseball.domain;

public enum NumberStatus {
    BALL("BALL", "볼"), 
    STRIKE("STRIKE", "스트라이크"), 
    NOTHING("NOTHING","낫싱");

    private final String key;
    private final String value;

    NumberStatus(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
