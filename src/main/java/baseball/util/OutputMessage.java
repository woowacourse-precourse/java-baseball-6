package baseball.util;

public enum OutputMessage {

    NOTHING("낫싱\n"),
    BALL("%d볼\n"),
    STRIKE("%d스트라이크\n"),
    BALL_STRIKE("%d볼 %d스트라이크\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(int ball, int strike) {
        return String.format(message, ball, strike);
    }

    public String getMessage(int ballOrStrike) {
        return String.format(message, ballOrStrike);
    }
    public String getMessage() { return message; }
}
