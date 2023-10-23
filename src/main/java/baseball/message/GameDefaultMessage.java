package baseball.message;

// 야구 게임을 하면서 로그에 출력할 메세지를 관리하는 클래스
public enum GameDefaultMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INPUT_VALUE("숫자를 입력해주세요 : "),
    INPUT_SIGNAL("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    ;

    private final String message;

    GameDefaultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
