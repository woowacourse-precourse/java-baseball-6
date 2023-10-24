package baseball.domain;

public enum BallType {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String text;

    BallType(String text) {
        this.text = text;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
