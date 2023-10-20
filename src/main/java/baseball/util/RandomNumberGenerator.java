package baseball.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    public int generate() {
        return pickNumberInRange(1, 9);
    }

}
