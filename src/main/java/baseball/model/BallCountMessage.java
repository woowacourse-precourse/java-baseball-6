package baseball.model;

public enum BallCountMessage {

    STRIKE("%d스트라이크 "),
    BALL("%d볼 "),
    NOTHING("낫싱\n");

    String message;

    BallCountMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
