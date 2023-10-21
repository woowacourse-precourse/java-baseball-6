package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    public static final int NUMBER_SIZE = 3;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 9;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBER_SIZE);
    }
}
