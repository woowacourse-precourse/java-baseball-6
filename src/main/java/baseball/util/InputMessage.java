package baseball.util;

public enum InputMessage {

    START("숫자 야구 게임을 시작합니다.\n"),
    INSERT_NUMBER("숫자를 입력해주세요 : "),
    CORRECT("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
