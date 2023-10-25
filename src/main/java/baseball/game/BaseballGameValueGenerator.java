package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class BaseballGameValueGenerator {
    public List<Integer> generateThreeRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}