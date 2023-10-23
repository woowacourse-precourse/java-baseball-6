package player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private static final int MIN_NUMBER = 1;
    public static final int MAX_LENGTH = 3;
    public static final String ONLY_THREE_NUMBER = "3자리의 숫자만 입력가능합니다.";
    public static final String NO_DUPLICATE_NUMBER = "중복된 숫자는 입력 불가능합니다.";
    public static final String INVALID_NUMBER_RANGE = "각 숫자는 1 ~ 9 까지만 입력 가능합니다.";

    private final List<Integer> baseballNumbers;

    public BaseballNumbers(List<Integer> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
        validateNumberLength();
        validateDuplicateNumber();
        validateBelowRange();
    }

    public int size() {
        return baseballNumbers.size();
    }

    public Integer get(int index) {
        return baseballNumbers.get(index);
    }

    public boolean contains(Integer baseballNumber) {
        return baseballNumbers.contains(baseballNumber);
    }

    private void validateNumberLength() {
        if (baseballNumbers.size() != MAX_LENGTH) {
            throw new IllegalArgumentException(ONLY_THREE_NUMBER);
        }
    }

    private void validateDuplicateNumber() {
        Set<Integer> baseballNumberSet = new HashSet<>(baseballNumbers);

        if (baseballNumberSet.size() < MAX_LENGTH) {
            throw new IllegalArgumentException(NO_DUPLICATE_NUMBER);
        }
    }

    private void validateBelowRange() {
        for (Integer baseballNumber : baseballNumbers) {
            if (baseballNumber < MIN_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
        }
    }
}
