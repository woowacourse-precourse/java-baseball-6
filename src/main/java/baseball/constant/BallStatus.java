package baseball.constant;

import java.util.Arrays;

public enum BallStatus {

    BALL(true),
    NOTHING(false);

    private final boolean isBall;

    BallStatus(boolean isBall) {
        this.isBall = isBall;
    }

    public static BallStatus getBallStatus(boolean isBall) {
        return Arrays.stream(BallStatus.values())
                .filter(value -> value.isBall == isBall)
                .findAny()
                .orElse(BallStatus.NOTHING);
    }
}
