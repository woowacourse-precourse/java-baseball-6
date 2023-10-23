package baseball.manager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> pickUniqueNumbersInRange(int start, int end, int count) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while (set.size() != count) {
            set.add(Randoms.pickNumberInRange(start, end));
        }
        return new ArrayList<>(set);
    }
}
