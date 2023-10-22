package player;

import static constant.BaseballConstant.INVALID_NUMBER_RANGE;
import static constant.BaseballConstant.MAX_LENGTH;
import static constant.BaseballConstant.NO_DUPLICATE_NUMBER;
import static constant.BaseballConstant.ONLY_THREE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

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
            if (baseballNumber < 0) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
        }
    }
}
