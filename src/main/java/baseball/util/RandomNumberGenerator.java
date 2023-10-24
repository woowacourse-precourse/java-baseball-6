package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int REPEAT_COUNT = 3;

    public static List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < REPEAT_COUNT; i++) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
