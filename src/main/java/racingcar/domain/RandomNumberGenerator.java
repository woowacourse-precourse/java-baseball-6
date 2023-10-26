package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int generate () {
        return Randoms.pickNumberInRange(0,9);
    }
}
