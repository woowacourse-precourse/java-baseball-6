package baseball.domain;

import java.util.List;

public class BaseballNumber {
    private final int value;

    public BaseballNumber(int value) {
        this.value = value;
    }

    public boolean isSameValue(BaseballNumber anotherNumber) {
        return this.value == anotherNumber.value;
    }

    public boolean isContainedIn(List<BaseballNumber> baseballNumbers) {
        return baseballNumbers.stream()
                .anyMatch(baseballNumber -> baseballNumber.isSameValue(this));
    }
}
