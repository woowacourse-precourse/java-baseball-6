package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerNumberGenerator {
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
