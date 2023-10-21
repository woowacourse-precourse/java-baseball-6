package baseball.domain.baseballnumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private static final int NUMBERS_SIZE = 3;
    private static final String ERROR_MESSAGE_WRONG_SIZE = "세 개의 숫자를 입력해 주세요.";
    private static final String ERROR_MESSAGE_DUPLICATED = "중복 없이 입력해 주세요.";

    private List<BaseballNumber> numbers = new ArrayList<>();

    public BaseballNumbers(List<Integer> input) {
        validateSizeAndDuplicated(input);
        input.forEach((number) -> numbers.add(new BaseballNumber(number)));
    }

    public List<BaseballNumber> numbers() {
        return numbers;
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
}
