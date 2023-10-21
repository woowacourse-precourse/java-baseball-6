package baseball.type;

/**
 *  @Enum  : 숫자 야구 게임의 출력 메세지 문자열
 *  @since   : 2023/10/21
 *  @auther  : SYB
 */
public enum MessageType {

    START("숫자 야구 게임을 시작합니다."),
    ASK("숫자를 입력해주세요 : "),
    SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임종료"),
    REPLAY_CHECK("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    ;

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
