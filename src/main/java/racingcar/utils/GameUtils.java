package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtils {

    public static int randomPickNumber() {
        int MAX_RANGE_NUMBER = 9;
        int MIN_RANGE_NUMBER = 0;
        return Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
    }
}
