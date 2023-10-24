package baseball.domain.score;

public enum Hint {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String string;

    Hint(String string) {
        this.string = string;
    }

    public String value() {
        return string;
    }
}
