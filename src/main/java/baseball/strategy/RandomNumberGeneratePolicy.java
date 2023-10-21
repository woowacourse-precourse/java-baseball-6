package baseball.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratePolicy implements NumberGeneratePolicy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

}
