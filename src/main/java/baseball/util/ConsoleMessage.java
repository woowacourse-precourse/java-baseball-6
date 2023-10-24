package baseball.util;

public enum ConsoleMessage {
    INPUT_PLAYER_NUMBER("숫자를 입력해주세요 : ");
    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
