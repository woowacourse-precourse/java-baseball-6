package number;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberPicker implements NumberPicker {

    private static final int DEFAULT_START_INCLUSIVE = 1;
    private static final int DEFAULT_END_INCLUSIVE = 9;

    private final int startInclusive;
    private final int endInclusive;

    public RandomNumberPicker() {
        this.startInclusive = DEFAULT_START_INCLUSIVE;
        this.endInclusive = DEFAULT_END_INCLUSIVE;
    }

    private RandomNumberPicker(
            final int startInclusive,
            final int endInclusive
    ) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public static RandomNumberPicker of(
            final int startInclusive,
            final int endInclusive
    ) {
        return new RandomNumberPicker(startInclusive, endInclusive);
    }

    public int pick() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
