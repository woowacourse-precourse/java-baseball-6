package baseball.game;

public enum GameHintType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String label;

    GameHintType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
