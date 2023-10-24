package player;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_LENGTH = 3;
    private static final String ONLY_THREE_NUMBER = "3자리의 숫자만 입력가능합니다.";
    private static final String NO_DUPLICATE_NUMBER = "중복된 숫자는 입력 불가능합니다.";
    private static final String INVALID_NUMBER_RANGE = "각 숫자는 1 ~ 9 까지만 입력 가능합니다.";
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
        validateNumberLength();
        validateDuplicateNumber();
        validateBelowRange();
    }

    private void validateNumberLength() {
        if (baseballNumbers.size() != MAX_LENGTH) {
            throw new IllegalArgumentException(ONLY_THREE_NUMBER);
        }
    }

    private void validateDuplicateNumber() {
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumbers);

        if (baseballNumberSet.size() < MAX_LENGTH) {
            throw new IllegalArgumentException(NO_DUPLICATE_NUMBER);
        }
    }

    private void validateBelowRange() {
        for (BaseballNumber baseballNumber : baseballNumbers) {
            if (baseballNumber.getBaseballNumber() < MIN_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
        }
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return Collections.unmodifiableList(baseballNumbers);
    }
}
