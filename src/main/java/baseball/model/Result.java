package baseball.model;

public enum Result {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String value;

    Result(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
