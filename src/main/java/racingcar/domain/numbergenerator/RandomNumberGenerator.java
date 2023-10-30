package racingcar.domain.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
