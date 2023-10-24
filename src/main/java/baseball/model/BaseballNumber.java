package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class BaseballNumber {
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;
    private static final String BASEBALL_NUMBER_OUT_OF_RANGE_ERROR = "숫자의 범위는 1에서 9까지";

    private static final Map<Integer, BaseballNumber> NUMBERS = new HashMap<>();

    public final int baseballNumber;

    static {
        for (int i = MIN_BASEBALL_NUMBER; i <= MAX_BASEBALL_NUMBER; i++) {
            NUMBERS.put(i, new BaseballNumber(i));
        }
    }

    public BaseballNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber of(int number) {
        BaseballNumber baseballNumber = NUMBERS.get(number);
        validateNumberInRange(baseballNumber);
        return baseballNumber;
    }

    private static void validateNumberInRange(BaseballNumber baseballNumber) {
        if (baseballNumber == null) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_OUT_OF_RANGE_ERROR);
        }
    }

    public static BaseballNumber pickRandom() {
        int randomNumber = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
        return of(randomNumber);
    }

    @Override
    public String toString() {
        return "BaseballNumber{" +
                "baseballNumber=" + baseballNumber +
                '}';
    }
}
