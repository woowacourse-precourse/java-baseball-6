package baseball.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
