package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomGenerator implements RandomGenerator {
    @Override
    public int pickNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
