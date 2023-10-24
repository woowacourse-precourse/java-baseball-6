package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public Integer generate(Integer minNumber, Integer maxNumber) {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }
}
