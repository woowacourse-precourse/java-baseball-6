package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private NumberGenerator() {
    }

    public static List<Integer> getRandomNumber(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
