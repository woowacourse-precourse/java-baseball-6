package baseball.config;

public enum Messages {
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    GUESS_NUM_MESSAGE("숫자를 입력해주세요 : "),
    BALL_MESSAGE("볼"),
    STRIKE_MESSAGE("스트라이크"),
    NOTHING_MESSAGE("낫싱"),
    SPACE(" ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
