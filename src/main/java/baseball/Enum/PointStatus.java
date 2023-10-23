package baseball.Enum;

public enum PointStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String description;

    PointStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
