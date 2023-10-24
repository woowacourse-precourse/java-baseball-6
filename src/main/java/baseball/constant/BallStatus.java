package baseball.constant;

import java.util.Arrays;

public enum BallStatus {

    STRIKE(true, true),
    BALL(true, false),
    NOTHING(false, false);

    private final boolean isBall;
    private final boolean isStrike;

    BallStatus(boolean isBall, boolean isStrike) {
        this.isBall = isBall;
        this.isStrike = isStrike;
    }

    public static BallStatus getBallStatus(boolean isBall, boolean isStrike) {
        return Arrays.stream(BallStatus.values())
                .filter(value -> value.isBall == isBall)
                .filter(value -> value.isStrike == isStrike)
                .findAny()
                .orElse(BallStatus.NOTHING);
    }
}
