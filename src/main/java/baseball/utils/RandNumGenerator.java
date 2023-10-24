package baseball.utils;

import static baseball.common.Constant.MAX_NUMBER_RANGE;
import static baseball.common.Constant.MIN_NUMBER_RANGE;
import static baseball.common.Constant.VALID_ANSWER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandNumGenerator {
    public static List<Integer> generateAnswerNumbers() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < VALID_ANSWER_SIZE) {
            set.add(Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE));
        }
        return new ArrayList<>(set);
    }

}
