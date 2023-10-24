package baseball.constant;

public enum JudgementMessage {
    NOTHING("낫싱"),
    ONLY_STRIKE("%d스트라이크"),
    ONLY_BALL("%d볼"),
    BALL_AND_STRIKE("%d볼 %d스트라이크"),
    ;

    private final String message;

    JudgementMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
