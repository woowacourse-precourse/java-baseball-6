package baseball.util;

public enum Messages {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    GET_USER_NUMBER_MESSAGE("숫자를 입력해주세요: ");

    private final String message;

    private Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
