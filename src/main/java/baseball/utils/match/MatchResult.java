package baseball.utils.match;

public enum MatchResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱")
    ;

    private final String name;

    MatchResult(String name) {
        this.name = name;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public String getName() {
        return name;
    }
}
