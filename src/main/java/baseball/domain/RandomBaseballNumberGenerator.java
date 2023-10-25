package baseball.domain;

import static baseball.domain.BaseballNumberConstants.BASEBALL_MAX_NUMBER;
import static baseball.domain.BaseballNumberConstants.BASEBALL_MIN_NUMBER;
import static baseball.domain.BaseballNumberConstants.BASEBALL_NUMBER_LEN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBaseballNumberGenerator {

    private List<Integer> numbers = new ArrayList<>();

    public BaseballNumber generate() {
        while (numbers.size() < BASEBALL_NUMBER_LEN) {
            numbers.add(getDigit());
        }
        return new BaseballNumber(numbers);
    }

    private int getDigit() {
        int number = getRandomDigit();
        if (numbers.contains(number)) {
            return getDigit();
        }
        return number;
    }

    private int getRandomDigit() {
        return Randoms.pickNumberInRange(BASEBALL_MIN_NUMBER, BASEBALL_MAX_NUMBER);
    }
}
