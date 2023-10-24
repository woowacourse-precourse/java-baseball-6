package baseball.model;

public enum BallCount {
    STRIKE("스트라이크", true, true),
    BALL("볼", true, false),
    NOTHING("낫싱", false, false);

    private final String baseballjudgment;
    private final boolean hasCommonNumber;
    private final boolean isInSamePosition;

    BallCount(String baseballjudgment, boolean hasCommonNumber, boolean isInSamePosition) {
        this.baseballjudgment = baseballjudgment;
        this.hasCommonNumber = hasCommonNumber;
        this.isInSamePosition = isInSamePosition;
    }

}