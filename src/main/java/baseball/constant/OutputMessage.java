package baseball.constant;

public enum OutputMessage {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    THREE_STRIKE_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    START_GAME("숫자 야구 게임을 시작합니다."),
    PLEASE_INPUT_NUMBER("숫자를 입력해주세요 : "),
    RESTART_GAME("게임을 새로 시작할면 1, 종료하려면 2를 입력하세요."),
    SPACE(" "),
    LINE_BREAK("\n");

    private final String message;

    private OutputMessage(String message) {
        this.message = message;
    }
}
