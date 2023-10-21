package baseball.constants.message;
public enum BaseballMessage {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    BLANK(" ");

    private final String message;

    BaseballMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
