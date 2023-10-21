package baseball.config;

public enum OutputViewConfig {
    GAME_START("숫자 야구 게임을 시작합니다."),
    REQUEST_PLAYER_NUMBER("숫자를 입력해주세요 : "),
    REQUEST_RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NOTHING("낫싱"),

    ;


    private final String message;

    OutputViewConfig(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
