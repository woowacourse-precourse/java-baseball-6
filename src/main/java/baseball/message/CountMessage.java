package baseball.message;

public enum CountMessage {

    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String message;

    CountMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString(int count) {
        if (count <= 0) {
            return "";
        }
        return count + getMessage();
    }
}
