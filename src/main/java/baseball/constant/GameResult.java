package baseball.constant;

public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String name;
    GameResult(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
