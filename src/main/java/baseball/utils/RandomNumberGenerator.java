package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private static final int MAX_NUMBER_NUM = 3;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 9;

    public List<Integer> generateNumbers() {
        final List<Integer> numbers = new ArrayList<>();
        while (isNeedMoreNumber(numbers)) {
            final int randomNumber = generateRandomNumber();
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private boolean isNeedMoreNumber(final List<Integer> numbers) {
        return numbers.size() < MAX_NUMBER_NUM;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
