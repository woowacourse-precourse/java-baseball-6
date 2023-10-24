package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtility {
    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final int BASEBALL_RANDOM_NUMBER_RANGE_START = 1;
    private static final int BASEBALL_RANDOM_NUMBER_RANGE_END = 9;

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            randomNumbers.add(generateRandomNumber(randomNumbers));
        }

        return randomNumbers;
    }

    private int generateRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_RANDOM_NUMBER_RANGE_START, BASEBALL_RANDOM_NUMBER_RANGE_END);

            if (isDiffNumber(randomNumbers, randomNumber)) {
                return randomNumber;
            }
        }
    }

    private boolean isDiffNumber(List<Integer> randomNumbers, int randomNumber) {
        return !randomNumbers.contains(randomNumber);
    }
}
