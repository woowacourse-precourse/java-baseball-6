package baseball.numbers;

import baseball.Constants;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final List<Integer> numbers;
    public Numbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constants.BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 3개가 아닙니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("숫자 0이 포함되어있습니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
