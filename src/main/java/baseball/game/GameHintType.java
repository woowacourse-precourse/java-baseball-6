package baseball.game;

public enum GameHintType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    ANSWER("3스트라이크");

    private final String label;

    GameHintType(String label) {
        this.label = label;
    }

    public String format(int count) {
        return switch (this) {
            case STRIKE, BALL -> count > 0 ? count + label : "";
            case NOTHING, ANSWER -> label;
        };
    }

    @Override
    public String toString() {
        return label;
    }
}
