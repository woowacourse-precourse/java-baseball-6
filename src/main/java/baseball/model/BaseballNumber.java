package baseball.model;

import static baseball.utils.BaseballConstantUtils.MAX_BASEBALL_NUMBER;
import static baseball.utils.BaseballConstantUtils.MIN_BASEBALL_NUMBER;

import java.util.Objects;

/**
 * 숫자야구 게임에서 사용되는 baseballNumber를 포장하는 클래스입니다.
 */

public class BaseballNumber {
    private final int baseballNumber;

    /**
     * baseballNumber 값이 숫자야구에 적합한지 검증 후 BaseballNumber 객체로 반환합니다.
     *
     * @param baseballNumber 검증 대상이 되는 int 값
     */

    public BaseballNumber(int baseballNumber) {
        validateBaseballNumber(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private void validateBaseballNumber(int baseballNumber) {
        if (baseballNumber < MIN_BASEBALL_NUMBER || baseballNumber > MAX_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 숫자가 " + MIN_BASEBALL_NUMBER + "~" + MAX_BASEBALL_NUMBER + " 사이가 아닙니다.");
        }
    }

    /**
     * baseballNumbers 필드를 사용하여 객체 간의 동등성을 확인합니다.
     *
     * <p>숫자 야구 게임에서는 두 BaseballNumber 객체를 비교하여 동일성 여부를 판단하는 동작이 게임의 핵심입니다.
     * 이 메서드는 두 객체가 동일한 baseballNumber 필드 값을 가지면 같다고 판단합니다.</p>
     *
     * @param object 비교할 대상 객체
     * @return 객체와 대상이 가진 baseballNumber 필드 값이 같은지 여부를 나타내는 판단
     */

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaseballNumber)) {
            return false;
        }
        return baseballNumber == ((BaseballNumber) object).baseballNumber;
    }

    /**
     * hashCode 메서드를 baseballNumber 필드를 활용하여 오버라이딩합니다.
     *
     * <p>이 메서드는 현재 숫자야구 게임에서 사용되지 않습니다. 하지만 equals 메서드를 오버라이딩할 때에는
     * hashCode 메서드도 오버라이딩하여 equals 메서드와 일관된 동작을 보장하는 것이 좋습니다.</p>
     *
     * @return 객체의 baseballNumber 필드를 기반으로 생성된 해시코드
     */

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumber);
    }
}
