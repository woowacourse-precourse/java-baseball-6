package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class BaseballNumber {
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;
    private final int baseballNumberInt;


    public BaseballNumber(int baseballNumberInt) {
        validateBaseballNumber(baseballNumberInt);
        this.baseballNumberInt = baseballNumberInt;
    }

    private static void validateBaseballNumber(int baseballNumberInt) {
        if (baseballNumberInt < MIN_BASEBALL_NUMBER || baseballNumberInt > MAX_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 숫자가 " + MIN_BASEBALL_NUMBER + "~" + MAX_BASEBALL_NUMBER + " 사이가 아닙니다."
            );
        }
    }

    public static int getBaseballNumberValue(BaseballNumber baseballNumber) {
        return baseballNumber.baseballNumberInt;
    }

    public static BaseballNumber getRandomBaseballNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
        return new BaseballNumber(randomNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseballNumber)) {
            return false;
        }
        BaseballNumber tmp = (BaseballNumber) o;
        if (this.baseballNumberInt == tmp.baseballNumberInt) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumberInt);
    }
}
