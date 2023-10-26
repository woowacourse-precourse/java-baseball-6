package baseball.util;

public enum ConsoleMessage {
    START_GAME("숫자 야구 게임을 시작합니다."),
    THREE_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INPUT_PLAYER_NUMBER("숫자를 입력해주세요 : ");
    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
