package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
    public List<Integer> createRandomList() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            while (true) {
                int randNum = Randoms.pickNumberInRange(1, 9);
                if (!randomNumbers.contains(randNum)) {
                    randomNumbers.add(randNum);
                    break;
                }
            }
        }

        return randomNumbers;
    }
}
