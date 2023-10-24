package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

}
