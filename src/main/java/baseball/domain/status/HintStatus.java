package baseball.domain.status;

public enum HintStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    ;

    private final String hint;

    HintStatus(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }
}
