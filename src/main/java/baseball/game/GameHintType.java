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
        switch (this) {
            case STRIKE:
            case BALL:
                return count > 0 ? count + label : "";
            case NOTHING:
            case ANSWER:
                return label;
            default:
                throw new IllegalArgumentException("지원하지 않는 형식입니다.");
        }
    }

    @Override
    public String toString() {
        return label;
    }
}
