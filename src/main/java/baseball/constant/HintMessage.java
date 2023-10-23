package baseball.constant;

public enum HintMessage {

    ONLY_BALL("%d볼"),
    ONLY_STRIKE("%d스트라이크"),
    NOTHING("낫싱");

    private final String message;


    HintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
