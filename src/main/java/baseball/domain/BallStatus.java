package baseball.domain;

import java.util.Arrays;

public enum BallStatus {
    STRIKE(true, true),
    BALL(true, false),
    VALUE_NOT_MATCHED(false, true),
    NOTHING_MATCHED(false, false);

    private final boolean valueMatches;
    private final boolean indexMatches;

    BallStatus(boolean valueMatches, boolean indexMatches) {
        this.valueMatches = valueMatches;
        this.indexMatches = indexMatches;
    }

    public static BallStatus of(boolean valueMatches, boolean indexMatches) {
        return Arrays.stream(values())
                .filter(ballStatus -> ballStatus.matches(valueMatches, indexMatches))
                .findAny()
                .get();
    }

    private boolean matches(boolean valueMatches, boolean indexMatches) {
        return this.valueMatches == valueMatches && this.indexMatches == indexMatches;
    }

    @Override
    public String toString() {
        return "BallStatus{" +
                "name=" + name() +
                '}';
    }
}
