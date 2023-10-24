package baseball.util;

import baseball.domain.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumberGenerator {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int NUMBER_COUNT = 3;

    public BaseballNumber generate() {
        Set<Integer> uniqueNumbers = generateUniqueRandomNumbers();

        Integer[] numbersArray = uniqueNumbers.toArray(new Integer[0]);
        return new BaseballNumber(numbersArray[0], numbersArray[1], numbersArray[2]);
    }

    private Set<Integer> generateUniqueRandomNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < NUMBER_COUNT) {
            uniqueNumbers.add(Randoms.pickNumberInRange(START_RANGE, END_RANGE));
        }

        return uniqueNumbers;
    }
}
