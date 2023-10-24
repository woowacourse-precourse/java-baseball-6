package baseball.collaborator.generic.message;

public enum BallCountMessage {

    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    BALL("볼"),
    ;

    private final String message;

    BallCountMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
