package baseball;

public enum Message {
    START_MESSAGE("숫자 야구 게임을 시작합니다.\n");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
