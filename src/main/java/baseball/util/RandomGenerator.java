package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    public static int generateNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

}
