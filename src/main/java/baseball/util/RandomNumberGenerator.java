package baseball.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    public int generate() {
        return pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
