package baseball.util.constant;

public enum GameMessage {
    START("숫자 야구 게임을 시작합니다.");

    String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
