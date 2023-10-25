package baseball;

public enum GameState {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    GameState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
