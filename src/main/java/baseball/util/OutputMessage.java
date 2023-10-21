package baseball.util;

public enum OutputMessage {

    NOTHING("낫싱\n"),
    BALL("%d볼\n"),
    STRIKE("%d스트라이크\n"),
    BALL_STRIKE("%d볼 %d스트라이크\n");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(int value1, int value2) {
        return String.format(message, value1, value2);
    }

    public String getMessage(int value) {
        return String.format(message, value);
    }
    public String getMessage() { return message; }
}
