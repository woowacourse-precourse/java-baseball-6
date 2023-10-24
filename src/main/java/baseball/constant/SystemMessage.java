package baseball.constant;

public enum SystemMessage {

    TYPE_NUMBER("숫자를 입력해주세요 : "),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    EXIT_FLAG("1"),
    RESTART_FLAG("2");
    
    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
