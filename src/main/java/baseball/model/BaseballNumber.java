package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class BaseballNumber {
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;
    private final int baseballNumberValue;


    public BaseballNumber(int baseballNumberValue) {
        validateBaseballNumber(baseballNumberValue);
        this.baseballNumberValue = baseballNumberValue;
    }

    private static void validateBaseballNumber(int baseballNumberValue) {
        if (baseballNumberValue < MIN_BASEBALL_NUMBER || baseballNumberValue > MAX_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 숫자가 " + MIN_BASEBALL_NUMBER + "~" + MAX_BASEBALL_NUMBER + " 사이가 아닙니다."
            );
        }
    }

    public static int getBaseballNumberValue(BaseballNumber baseballNumber) {
        return baseballNumber.baseballNumberValue;
    }

    public static BaseballNumber getRandomBaseballNumber() {
        int randomValue = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
        return new BaseballNumber(randomValue);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseballNumber)) {
            return false;
        }
        BaseballNumber baseballNumber = (BaseballNumber) o;
        if (this.baseballNumberValue == baseballNumber.baseballNumberValue) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumberValue);
    }
}
