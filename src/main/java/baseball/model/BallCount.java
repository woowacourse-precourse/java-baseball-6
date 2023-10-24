package baseball.model;

import baseball.util.ExceptionMessage;
import java.util.Arrays;

public enum BallCount {
    BALL(true, false),
    STRIKE(true, true),
    NOTHING(false, false);

    private final boolean hasSameNumber;
    private final boolean isSamePosition;

    private BallCount(boolean hasSameNumber, boolean isSamePosition) {
        this.hasSameNumber = hasSameNumber;
        this.isSamePosition = isSamePosition;
    }

    public static BallCount judge(boolean hasSameNumber, boolean isSamePosition) {
        return Arrays.stream(BallCount.values())
                .filter(ballCount -> ballCount.hasSameNumber == hasSameNumber)
                .filter(ballCount -> ballCount.isSamePosition == isSamePosition)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.WRONG_JUDGE));
    }

}
