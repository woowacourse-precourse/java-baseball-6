package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public static List<Integer> generateUniqueRandomDigitList(int size) {
        Assertions.assertInRange(size, 1, 9);

        final List<Integer> ret = new ArrayList<>();
        while (ret.size() < size) {
            final int pick = Randoms.pickNumberInRange(1, 9);
            CollectionUtil.addIfNotExist(ret, pick);
        }
        return ret;
    }
}
