package baseball.util;

public enum ConsoleMessage {
    INPUT_PLAYER_NUMBER("숫자를 입력해주세요 : "),
    OUTPUT_GAME_START("숫자 야구 게임을 시작합니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
