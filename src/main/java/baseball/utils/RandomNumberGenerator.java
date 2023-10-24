package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private static RandomNumberGenerator instance;

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        if (instance == null) {
            instance = new RandomNumberGenerator();
        }
        return instance;
    }

    public List<Integer> makeUniQueRandomNumbers(int minNum, int maxNum, int size) {
        List<Integer> uniqueRandomNumbers = new ArrayList<>();

        while (uniqueRandomNumbers.size() < size) {
            int randomNum = pickRandomNumber(minNum, maxNum);
            if (isUniqueNumber(randomNum, uniqueRandomNumbers)) {
                uniqueRandomNumbers.add(randomNum);
            }
        }
        return uniqueRandomNumbers;
    }

    private boolean isUniqueNumber(int randomNum, List<Integer> uniqueRandomNumbers) {
        return uniqueRandomNumbers.contains(randomNum);
    }

    private int pickRandomNumber(int minNum, int maxNum) {
        return Randoms.pickNumberInRange(minNum, maxNum);
    }

}
