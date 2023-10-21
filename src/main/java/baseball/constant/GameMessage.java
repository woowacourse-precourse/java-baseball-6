package baseball.constant;

public enum GameMessage {
    GAME_START("숫자 야구 게임을 시작합니다.");

    private final String message;

    GameMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
