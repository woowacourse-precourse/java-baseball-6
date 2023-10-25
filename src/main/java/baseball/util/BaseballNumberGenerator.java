package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGenerator {
    private static final int NUMBER_COUNT = 3;
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM = 9;

    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }
}