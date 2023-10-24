package baseball.constant;

public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String korean;

    GameResult(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
