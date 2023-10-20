package baseball.util;

import static baseball.util.NumberConstants.LIMIT_NUMBERS_SIZE;
import static baseball.util.NumberConstants.MAX_RANGE_NUMBER;
import static baseball.util.NumberConstants.MIN_RANGE_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGeneration {

    private final List<Integer> numberList;

    public NumberGeneration() {
        numberList = setRandomNumber();
    }

    public List<Integer> getComputerNumber() {
        return numberList;
    }

    public List<Integer> setRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < LIMIT_NUMBERS_SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(
                    MIN_RANGE_NUMBER.getValue(),
                    MAX_RANGE_NUMBER.getValue()
            );
            numberList.add(randomNumber);
        }
        return numberList;
    }

}
