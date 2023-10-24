package baseball.domain;

import baseball.common.config.BaseballMessageConst;

public enum Strike {
    ZERO(0), ONE(1), TWO(2), THREE(3);
    private final int strikeCount;

    Strike(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public static Strike of(int strikeCount) {
        for (Strike strike : values()) {
            if (strike.strikeCount == strikeCount) {
                return strike;
            }
        }
        throw new IllegalArgumentException(BaseballMessageConst.OUT_OF_RANGE_BALL_ERROR);
    }

}
