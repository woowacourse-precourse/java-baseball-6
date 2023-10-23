package baseball.model;

public enum BallCount {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String baseballjudgment;

    BallCount(String baseballjudgment) {
        this.baseballjudgment = baseballjudgment;
    }
}
