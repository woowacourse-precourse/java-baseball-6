package baseball.model.enums;

public enum ScoreMessage {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private String message;

    ScoreMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
