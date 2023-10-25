package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class BaseballRandomGenerator implements RandomNumberGenerator {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    @Override
    public String generateNonRepeatingRandomDigitSequence(int size) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> history = new HashSet<>();
        while (history.size() < size) {
            int num = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (history.contains(num)) {
                continue;
            }
            sb.append(num);
            history.add(num);
        }
        return sb.toString();
    }
}
