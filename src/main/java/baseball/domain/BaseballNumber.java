package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumber {
    public static final int MIN_BASEBALL_NUMBER = 1;
    public static final int MAX_BASEBALL_NUMBER = 9;

    private final int baseballNumber;

    private BaseballNumber(final int baseballNumber) {
        validation(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber from(final int baseballNumber) {
        return new BaseballNumber(baseballNumber);
    }

    public int getBaseballNumber() {
        return this.baseballNumber;
    }

    private void validation(final int baseballNumber) {
        if(baseballNumber < MIN_BASEBALL_NUMBER || baseballNumber > MAX_BASEBALL_NUMBER) {
            throw new IllegalArgumentException("숫자의 범위가 올바르지 않습니다. (1~9)");
        }
    }

    public int matchIndex(List<BaseballNumber> targetNumbers) {
        return targetNumbers.stream()
                .map(targetNumber -> targetNumber.getBaseballNumber())
                .collect(Collectors.toList())
                .indexOf(baseballNumber);
    }
}