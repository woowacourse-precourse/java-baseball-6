package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NextStepRandomNumberGenerator implements RandomNumberGenerator {
    public int pickNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
