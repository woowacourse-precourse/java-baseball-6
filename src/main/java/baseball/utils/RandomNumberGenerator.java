package baseball.utils;

import static baseball.utils.Constants.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 9;

    @Override
    public List<Integer> generate() {
        HashSet<Integer> picks = new HashSet<>();
        while (picks.size() < NUMBER_SIZE) {
            picks.add(Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE));
        }
        return new ArrayList<>(picks);
    }
}
