package baseball.hint;

public enum Hint {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private String hint;

    private Hint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }
}
