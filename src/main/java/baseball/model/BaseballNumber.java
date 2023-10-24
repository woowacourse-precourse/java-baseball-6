package baseball.model;

import java.util.*;
import java.util.stream.Collectors;

public class BaseballNumber {
    private static final int NUMBER_SIZE = 3;
    private List<Integer> baseballNumber;

    public BaseballNumber(List<Integer> baseballNumber) {
        validateNumberSizeAndDuplicate(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    public List<Integer> getBaseballNumberList() {
        return baseballNumber;
    }

    private void validateNumberSizeAndDuplicate(List<Integer> baseballNumber) {
        if (baseballNumber.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 야구는 3자리여야 합니다.");
        }

        Set<Integer> uniqueDigits = new HashSet<>(baseballNumber);
        if (uniqueDigits.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 야구는 각 자리가 중복될 수 없습니다.");
        }
    }

}
