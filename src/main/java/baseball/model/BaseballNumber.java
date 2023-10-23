package baseball.model;

import static baseball.utils.BaseballConstantUtils.MAX_BASEBALL_NUMBER;
import static baseball.utils.BaseballConstantUtils.MIN_BASEBALL_NUMBER;

import java.util.Objects;

/**
 * baseballNumber를 포장한 객체
 */

public class BaseballNumber {
    private final int baseballNumber;

    /**
     * baseballNumber 값을 검증 후 BaseballNumber 객체로 반환
     *
     * @param baseballNumber 검증할 int 값
     */

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
