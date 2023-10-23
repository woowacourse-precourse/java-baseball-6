package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandNumGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    private RandNumGenerator() {
    }

    private static int makeRandNumInRange() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
