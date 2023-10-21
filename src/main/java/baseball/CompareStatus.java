package baseball;

public enum CompareStatus {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String value;

    CompareStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}