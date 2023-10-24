package baseball.model;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseballNumber 객체들을 담는 일급컬렉션입니다.
 */

public class BaseballNumbers {
    private final List<BaseballNumber> baseballNumbers;

    /**
     * 숫자야구 값이 담긴 리스트에 중복이 있는지, 길이가 적합한지 검사 후 객체를 반환합니다.
     *
     * <p>매개변수가 가리키는 리스트를 그대로 baseballNumbers가 가리키게 된다면,
     * 매개변수에 의해 BaseballNumbers 객체가 갖는 리스트의 요소가 변동될 위험성이 있습니다. BaseballNumbers 객체는 한 번 할당받은 BaseballNumber 리스트가 변경되지 않도록
     * 의도하여 설계되었으므로 새로운 리스트 객체를 생성하여 멤버변수가 가리키도록 합니다.</p>
     *
     * @param baseballNumbers 숫자야구 값을 담은 리스트
     */

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateBaseballNumbers(baseballNumbers);
        this.baseballNumbers = new ArrayList<>(baseballNumbers);
    }

    private void validateBaseballNumbers(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != BASEBALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 숫자야구 값의 길이가 " + BASEBALL_NUMBERS_LENGTH + "(이)가 아닙니다.");
        }
        List<BaseballNumber> distinctBaseballNumbers = baseballNumbers.stream()
                .distinct()
                .toList();
        if (baseballNumbers.size() != distinctBaseballNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자야구 값에 중복 값이 있습니다.");
        }
    }

    /**
     * index에 맞는 숫자야구 객체를 반환합니다.
     *
     * @param index 숫자야구 값을 담는 리스트의 인덱스
     * @return index에 맞는 숫자야구 객체
     */

    public BaseballNumber getBaseballNumber(int index) {
        return baseballNumbers.get(index);
    }

    /**
     * 특정 숫자야구 값이 리스트에 포함되어 있는지 검사합니다.
     *
     * @param baseballNumber 리스트에 포함되어 있는지 확인하고 싶은 객체
     * @return 리스트의 해당 객체 포함여부
     */

    public boolean containsBaseballNumber(BaseballNumber baseballNumber) {
        return baseballNumbers.contains(baseballNumber);
    }
}
