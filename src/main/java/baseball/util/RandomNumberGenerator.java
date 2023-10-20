package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> getRandom3Number() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
        return randomNums;
    }
}
