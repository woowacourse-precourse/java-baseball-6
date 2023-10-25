package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static final int NUMBER_LENGTH = 3;

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            randomNumbers.add(createRandomNumber(randomNumbers));
        }

        return randomNumbers;
    }

    private int createRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(randomNumber)) {
                return randomNumber;
            }
        }
    }

}
