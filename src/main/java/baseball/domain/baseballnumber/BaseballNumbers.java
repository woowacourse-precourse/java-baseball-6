package baseball.domain.baseballnumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumbers {

    private static final int NUMBERS_SIZE = 3;
    private static final String ERROR_MESSAGE_WRONG_SIZE = "세 개의 숫자를 입력해 주세요.";
    private static final String ERROR_MESSAGE_DUPLICATED = "중복 없이 입력해 주세요.";

    private final List<BaseballNumber> numbers;

    public BaseballNumbers(List<Integer> input) {
        validateSizeAndDuplicated(input);
        List<BaseballNumber> baseballNumbers = input.stream().map(BaseballNumber::new)
            .collect(Collectors.toList());
        numbers = baseballNumbers;
    }

    private void validateSizeAndDuplicated(List<Integer> input) {
        if (!isRightSizeInput(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_SIZE);
        } else if (!isDuplicated(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATED);
        }
    }

    private boolean isRightSizeInput(List<Integer> input) {
        return input.size() == NUMBERS_SIZE;
    }

    private boolean isDuplicated(List<Integer> input) {
        Set<Integer> set = new HashSet<>(input);
        return set.size() == NUMBERS_SIZE;
    }

    public List<BaseballNumber> numbers() {
        return numbers;
    }

    public BaseballNumber get(int index) {
        return numbers.get(index);
    }

    public boolean containsWithDifferentIndex(BaseballNumber baseballNumber, int index) {
        return numbers.contains(baseballNumber) && !isSameIndex(baseballNumber, index);
    }

    public boolean containsWithSameIndex(BaseballNumber baseballNumber, int index) {
        return numbers.contains(baseballNumber) && isSameIndex(baseballNumber, index);
    }

    private boolean isSameIndex(BaseballNumber baseballNumber, int index) {
        int indexOfBaseballNumber = numbers.indexOf(baseballNumber);
        return indexOfBaseballNumber == index;
    }
}
