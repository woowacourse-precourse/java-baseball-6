package baseball.baseballV2.model;

public enum Result {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String description;

    Result(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
