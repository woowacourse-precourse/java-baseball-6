package baseball.printer;

public enum PrintMessage {
    GREET("숫자 야구 게임을 시작합니다."),
    REQUEST_INPUT_GAME_NUMBER("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    NOTICE_WIN("3개 숫자를 모두 맞히셨습니다! 게임 종료"),
    REQUEST_INPUT_RESTART_NUMBER("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    public String getMessage() {
        return message;
    }

    PrintMessage(String message) {
        this.message = message;
    }
}
