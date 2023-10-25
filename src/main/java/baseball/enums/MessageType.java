package baseball.enums;

public enum MessageType {
    START("숫자 야구 게임을 시작합니다."),
    ASK_FOR_NUMBER("숫자를 입력해주세요 : "),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_FOR_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    GAME_ENDED("게임 종료"),
    RESTART("1"),
    FINISH("2");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
