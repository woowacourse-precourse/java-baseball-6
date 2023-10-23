package baseball.utils;

public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    WIN_STRIKES("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
