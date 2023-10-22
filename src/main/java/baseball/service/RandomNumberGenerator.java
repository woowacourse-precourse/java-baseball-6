package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    public static int MIN_RANDOM_NUMBER = 1;
    public static int MAX_RANDOM_NUMBER = 9;
    public static int THREE_DIGIT_NUMBER_RANGE = 3;

    public List<Integer> generateRandomNumbers() {
        return generateUniqueThreeDigitNumbers();
    }

    private List<Integer> generateUniqueThreeDigitNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, THREE_DIGIT_NUMBER_RANGE);
    }
}
