package baseball.util.constant;

public enum GameMessage {
    START("숫자 야구 게임을 시작합니다.\n"),
    REQUEST_BAT("숫자를 입력해주세요 : ");

    String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
