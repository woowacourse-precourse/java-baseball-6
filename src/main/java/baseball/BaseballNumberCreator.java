package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumberCreator implements NumberCreator {
    private static final int LOWER_RANGE = 1;
    private static final int UPPER_RANGE = 9;

    @Override
    public int create() {
        return Randoms.pickNumberInRange(LOWER_RANGE, UPPER_RANGE);
    }
}
