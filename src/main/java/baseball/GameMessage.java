package baseball;

public enum GameMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    NUMBER_INPUT("숫자를 입력해주세요 : ");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
