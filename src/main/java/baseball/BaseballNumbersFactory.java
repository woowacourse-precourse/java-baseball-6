package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbersFactory {
    private static final int BASEBALL_NUMBERS_LENGTH = 3;

    private BaseballNumbersFactory() {
    }

    public static List<BaseballNumber> getRandomBaseballNumbers() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() != BASEBALL_NUMBERS_LENGTH) {
            BaseballNumber randomBaseballNumber = BaseballNumber.getRandomBaseballNumber();
            if (!baseballNumbers.contains(randomBaseballNumber)) {
                baseballNumbers.add(randomBaseballNumber);
            }
        }
        return baseballNumbers;
    }
}
