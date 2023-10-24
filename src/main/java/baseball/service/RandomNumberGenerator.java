package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomNumberGenerator {
    public static int MIN_RANDOM_NUMBER = 1;
    public static int MAX_RANDOM_NUMBER = 9;
    public static int THREE_DIGIT_NUMBER_RANGE = 3;

    public List<Integer> generateRandomNumbers() {
        return generateUniqueThreeDigitNumbers();
    }

    private List<Integer> generateUniqueThreeDigitNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < THREE_DIGIT_NUMBER_RANGE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
