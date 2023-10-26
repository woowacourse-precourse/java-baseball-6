package baseball.model;

import baseball.util.ExceptionMessage;
import java.util.Arrays;

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

    public static BallCount decideBallCount(boolean hasCommonNumber, boolean isInSamePosition) {
        return Arrays.stream(BallCount.values())
                .filter(ballCount -> ballCount.hasCommonNumber == hasCommonNumber)
                .filter(ballCount -> ballCount.isInSamePosition == isInSamePosition)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_BALL_COUNT.getMessage()));
    }

    public String getBaseballjudgment() {
        return baseballjudgment;
    }
}