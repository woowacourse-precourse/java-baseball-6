package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {

    public static List<Integer> generateRandomNumbers(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

}
