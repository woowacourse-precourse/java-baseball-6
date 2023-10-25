package baseball.domain;

import static baseball.constant.BaseballSystemPolicy.LIMIT_LENGTH;
import static baseball.constant.BaseballSystemPolicy.MAXIMUM_NUMBER;
import static baseball.constant.BaseballSystemPolicy.MINIMUM_NUMBER;

import java.util.List;

public class Computer {

    private List<Integer> randomNumbers;

    public Computer(List<Integer> randomNumbers) {
        validLimitSize(randomNumbers);
        validUniqueNumber(randomNumbers);
        validValue(randomNumbers);
        this.randomNumbers = randomNumbers;
    }

    public boolean exactlyMatch(int index, int value) {
        return this.randomNumbers.get(index) == value;
    }

    public boolean isContains(int value) {
        return this.randomNumbers.contains(value);
    }

    private void validUniqueNumber(List<Integer> randomNumbers) {
        int uniqueCount = (int) randomNumbers.stream().distinct().count();
        if (LIMIT_LENGTH.getCondition() != (uniqueCount)) {
            throw new IllegalArgumentException("고유한 숫자 3자리가 아닙니다.");
        }
    }

    private void validLimitSize(List<Integer> randomNumbers) {
        if (LIMIT_LENGTH.getCondition() != randomNumbers.size()) {
            throw new IllegalArgumentException("제한된 길이 3과 같지 않습니다.");
        }
    }

    private void validValue(List<Integer> randomNumbers) {
        randomNumbers.stream()
                .filter((value) -> value < MINIMUM_NUMBER.getCondition() || value > MAXIMUM_NUMBER.getCondition())
                .findAny()
                .ifPresent((value) -> {
                    throw new IllegalArgumentException("제한된 길이 3과 같지 않습니다.");
                });
    }

}
