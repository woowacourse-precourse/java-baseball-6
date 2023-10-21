package baseball.constants;

public enum GameMessage {

    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    GET_USER_INPUT("숫자를 입력해주세요 : ");
    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
