package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomTargetNumbers extends CommonNumbers {

    private RandomTargetNumbers(String intStr) {
        super(intStr);
    }

    public static RandomTargetNumbers generate() {
        StringBuilder sb = new StringBuilder();
        List<Integer> nc = new ArrayList<>(LENGTH);
        while (sb.length() < LENGTH) {
            int randomizedNum = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!nc.contains(randomizedNum)) {
                nc.add(randomizedNum);
                sb.append(randomizedNum);
            }
        }
        return new RandomTargetNumbers(sb.toString());
    }
}
