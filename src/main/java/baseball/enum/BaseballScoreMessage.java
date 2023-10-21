package baseball;

public enum BaseballScoreMessage {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    BaseballScoreMessage(String message) { this.message = message; }

    public String getMessageWithCount(int count) {
        return count + this.message;
    }

    @Override
    public String toString() {
        return message;
    }

}
