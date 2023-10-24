package baseball;

public enum NoticeType {
    GAME_START("숫자 야구 게임을 시작합니다."),

    REQUEST_INPUT("숫자를 입력해주세요 : "),

    GAME_WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),

    NOTHING("낫싱"),

    RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    NoticeType(String message) { this.message = message; }

    public String getMessage() { return message; }
}
