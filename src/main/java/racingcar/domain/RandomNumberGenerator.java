package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(0,9);
    }
}
