package baseball.util;

import baseball.domain.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class BaseballNumberGenerator {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int NUMBER_COUNT = 3;

    public BaseballNumber generate() {
        List<Integer> randomNumbers = getRandomNumbers();
        return new BaseballNumber(randomNumbers.get(0), randomNumbers.get(1), randomNumbers.get(2));
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
