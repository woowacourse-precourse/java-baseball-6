package baseball.model;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseballNumber 객체들을 담는 일급컬렉션
 */

public class BaseballNumbers {
    private final List<BaseballNumber> baseballNumbers;

    /**
     * BaseballNumber 리스트를 검증 후 BaseballNumbers 객체로 반환
     *
     * @param baseballNumbers 일급컬렉션으로 포장되기 전 리스트
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
     * 일급컬렉션의 index를 보고 객체를 반환
     *
     * @param index 일급컬렉션의 인덱스
     * @return 일급컬렉션의 index에 해당하는 객체
     */

    public BaseballNumber getBaseballNumber(int index) {
        return baseballNumbers.get(index);
    }

    /**
     * 일급컬렉션에 특정 객체가 포함되어 있는지 검사
     *
     * @param baseballNumber 포함 여부를 검사할 객체
     * @return 포함여부
     */

    public boolean containsBaseballNumber(BaseballNumber baseballNumber) {
        return baseballNumbers.contains(baseballNumber);
    }
}
