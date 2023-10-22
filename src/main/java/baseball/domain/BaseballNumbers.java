package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private static final String DUPLICATE_NUMBER_MESSAGE = "중복된 숫자가 있습니다.";
    private static final String INVALID_SIZE_MESSAGE = "숫자는 3개여야 합니다.";
    private static final int BASEBALL_NUMBER_SIZE = 3;
    private final List<BaseballNumber> numbers;

    public BaseballNumbers(final List<BaseballNumber> inputNumbers) {
        validateSize(inputNumbers);
        this.numbers = new ArrayList<>();
        numbers.addAll(inputNumbers);
        validateDuplication(numbers);
    }

    private void validateSize(final List<BaseballNumber> inputNumbers) {
        if (inputNumbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private void validateDuplication(final List<BaseballNumber> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public int countMatchingNumbersAtSamePosition(final BaseballNumbers other) {
        int count = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            if (this.numbers.get(i).equals(other.numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countMatchingNumbers(final BaseballNumbers other) {
        int count = 0;
        for (BaseballNumber number : this.numbers) {
            if (other.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
