package baseball.domain.baseballnumber;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private static final int NUMBERS_SIZE = 3;
    private static final String ERROR_MESSAGE_WRONG_SIZE = "세 개의 숫자를 중복 없이 입력해 주세요.";

    private Set<BaseballNumber> numbers = new LinkedHashSet<>();

    public BaseballNumbers(List<Integer> input) {
        input.forEach((number) -> numbers.add(new BaseballNumber(number)));
        validateSize();
    }

    public List<BaseballNumber> numbers() {
        return new ArrayList<>(numbers);
    }

    private void validateSize() {
        if (!isRightSize()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_SIZE);
        }
    }

    private boolean isRightSize() {
        return numbers.size() == NUMBERS_SIZE;
    }
}
