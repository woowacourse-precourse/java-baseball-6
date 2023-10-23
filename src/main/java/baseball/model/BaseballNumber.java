package baseball.model;

import static baseball.utils.BaseballConstantUtils.MAX_BASEBALL_NUMBER;
import static baseball.utils.BaseballConstantUtils.MIN_BASEBALL_NUMBER;

import java.util.Objects;

/**
 * 숫자야구 게임을 위해 사용되는 비교대상
 */

public class BaseballNumber {
    private final int baseballNumber;


    public BaseballNumber(int baseballNumber) {
        validateBaseballNumber(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private static void validateBaseballNumber(int baseballNumber) {
        if (baseballNumber < MIN_BASEBALL_NUMBER || baseballNumber > MAX_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 숫자가 " + MIN_BASEBALL_NUMBER + "~" + MAX_BASEBALL_NUMBER + " 사이가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaseballNumber)) {
            return false;
        }
        return baseballNumber == ((BaseballNumber) object).baseballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumber);
    }
}
