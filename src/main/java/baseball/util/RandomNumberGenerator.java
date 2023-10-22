package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private final int startInclusive;
    private final int endInclusive;

    public RandomNumberGenerator(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    @Override
    public int createNumber() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
