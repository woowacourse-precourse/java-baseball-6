package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    private static final int RANDOM_NUMBER_LENGTH = 3;
    private static final int RANGE_START_RANDOM_NUMBER = 1;
    private static final int RANGE_END_RANDOM_NUMBER = 9;


    public static List<Integer> createRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START_RANDOM_NUMBER, RANGE_END_RANDOM_NUMBER);
            if (validateContainNumber(randomNumbers, randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private static boolean validateContainNumber(List<Integer> randomNumbers, int randomNumber) {
        return (!randomNumbers.contains(randomNumber));
    }
}
