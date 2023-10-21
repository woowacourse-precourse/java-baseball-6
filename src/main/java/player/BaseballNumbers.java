package player;

import static constant.NumberConstant.MAX_LENGTH;
import static constant.StringConstant.NO_DUPLICATE_NUMBER_MESSAGE;
import static constant.StringConstant.ONLY_THREE_NUMBER_MESSAGE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private List<BaseballNumber> baseballNumbers;

    public BaseballNumbers() {
        this.baseballNumbers = new ArrayList<>();
    }

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateMaxLength(baseballNumbers);
        validateDuplicateNumber(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public int size() {
        return baseballNumbers.size();
    }

    public BaseballNumber get(int index) {
        return baseballNumbers.get(index);
    }

    public boolean contains(BaseballNumber baseballNumber) {
        return baseballNumbers.contains(baseballNumber);
    }

    private void validateMaxLength(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() > MAX_LENGTH) {
            throw new IllegalArgumentException(ONLY_THREE_NUMBER_MESSAGE);
        }
    }

    private void validateDuplicateNumber(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumbers);

        if (baseballNumberSet.size() < MAX_LENGTH) {
            throw new IllegalArgumentException(NO_DUPLICATE_NUMBER_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object baseballNumbers) {
        BaseballNumbers otherBaseballNumber = (BaseballNumbers) baseballNumbers;

        for (int i = 0; i < this.baseballNumbers.size(); i++) {
            if (!otherBaseballNumber.get(i).equals(this.baseballNumbers.get(i))) {
                return false;
            }
        }

        return true;
    }
}
