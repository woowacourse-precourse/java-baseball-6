package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
public class RandomNumberGenerator {

    private static final int MIN_LIMIT = 1;
    private static final int MAX_LIMIT = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(MIN_LIMIT, MAX_LIMIT);
    }
}
