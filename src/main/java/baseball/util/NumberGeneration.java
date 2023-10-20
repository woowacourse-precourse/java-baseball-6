package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGeneration {

    private static final int LIMIT_NUMBERS_SIZE = 3;
    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 9;
    private final List<Integer> numberList;

    public NumberGeneration() {
        numberList = setRandomNumber();
    }

    public List<Integer> getComputerNumber() {
        return numberList;
    }

    public List<Integer> setRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < LIMIT_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
            numberList.add(randomNumber);
        }
        return numberList;
    }

}
