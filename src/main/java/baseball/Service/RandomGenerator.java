package baseball.Service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static String getRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(100, 999));
    }

}
