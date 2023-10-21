package baseball;

public enum BaseballJudgement {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    public final String message;

    BaseballJudgement(String message) {
        this.message = message;
    }
}
