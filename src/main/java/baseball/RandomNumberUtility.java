package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberUtility {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            randomNumbers.add(getDistinctRandomNumber(randomNumbers));
        }

        return randomNumbers;
    }

    private Integer getDistinctRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int num = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!isDistinct(num, randomNumbers)) continue;
            return num;
        }
    }

    private boolean isDistinct(int num, List<Integer> randomNumbers) {
        return !randomNumbers.contains(num);
    }
}
