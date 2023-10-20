package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public static List<Integer> generateUniqueRandomListOf(int size) {
        Assertions.assertInRange(size, 0, 8);
        final List<Integer> ret = new ArrayList<>();
        while (ret.size() < size) {
            var rnd = Randoms.pickNumberInRange(1, 9);
            if (!ret.contains(rnd)) {
                ret.add(rnd);
            }
        }
        return ret;
    }
}
