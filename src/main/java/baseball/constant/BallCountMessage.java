package baseball.constant;

public enum BallCountMessage {
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱");

    private final String message;

    BallCountMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
