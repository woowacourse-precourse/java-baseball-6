package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> generateRandomUniqueThreeNumbers() {
        List<Integer> randomUniqueThreeNumbers = new ArrayList<>();
        while (randomUniqueThreeNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomUniqueThreeNumbers.contains(randomNumber)) {
                randomUniqueThreeNumbers.add(randomNumber);
            }
        }
        return randomUniqueThreeNumbers;
    }
}
