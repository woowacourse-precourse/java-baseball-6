package baseball.collaborator.generic.enums;

public enum BallCountMessage {

    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    BALL("볼"),
    INCORRECT_BALLCOUNTING("잘못된 볼카운팅입니다."),
    ;

    private final String message;

    BallCountMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
