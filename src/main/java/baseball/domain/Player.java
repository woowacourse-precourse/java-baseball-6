package baseball.domain;

import static baseball.constant.BaseballSystemPolicy.LIMIT_LENGTH;
import static baseball.constant.BaseballSystemPolicy.MAXIMUM_NUMBER;
import static baseball.constant.BaseballSystemPolicy.MINIMUM_NUMBER;

import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player(List<Integer> numbers) {
        validLimitSize(numbers);
        validUniqueNumber(numbers);
        validValue(numbers);
        this.numbers = numbers;
    }

    public Integer getValue(int index) {
        return this.numbers.get(index);
    }

    private void validUniqueNumber(List<Integer> numbers) {
        int uniqueCount = (int) numbers.stream().distinct().count();
        if (LIMIT_LENGTH.getCondition() != (uniqueCount)) {
            throw new IllegalArgumentException("고유한 숫자 3자리가 아닙니다.");
        }
    }

    private void validLimitSize(List<Integer> numbers) {
        if (LIMIT_LENGTH.getCondition() != (numbers.size())) {
            throw new IllegalArgumentException("제한된 길이 3과 같지 않습니다.");
        }
    }

    private void validValue(List<Integer> numbers) {
        numbers.stream()
                .filter((value) -> value < MINIMUM_NUMBER.getCondition() || value > MAXIMUM_NUMBER.getCondition())
                .findAny()
                .ifPresent((value) -> {
                    throw new IllegalArgumentException("제한된 길이 3과 같지 않습니다.");
                });
    }
}
