package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    static final int SIZE_OF_NUMBERS = 3;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    public static List<Integer> generateRandomUniqueThreeNumbers() {
        List<Integer> randomUniqueThreeNumbers = new ArrayList<>();
        while (randomUniqueThreeNumbers.size() < SIZE_OF_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomUniqueThreeNumbers.contains(randomNumber)) {
                randomUniqueThreeNumbers.add(randomNumber);
            }
        }
        return randomUniqueThreeNumbers;
    }
}
