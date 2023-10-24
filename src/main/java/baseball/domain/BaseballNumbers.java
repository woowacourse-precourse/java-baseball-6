package baseball.domain;

import static baseball.console.Constant.EXCEPTION_BASEBALL_NUMBERS_DUPLICATE_MESSAGE;
import static baseball.console.Constant.EXCEPTION_BASEBALL_NUMBERS_SIZE_MESSAGE;

import java.util.List;

public class BaseballNumbers {

    private static final int NUMBERS_MAX_SIXE = 3;
    private final List<BaseballNumber> numbers;

    public BaseballNumbers(List<BaseballNumber> numbers) {
        isValidSize(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void isValidSize(List<BaseballNumber> numbers) {
        if (numbers.size() != NUMBERS_MAX_SIXE) {
            throw new IllegalArgumentException(EXCEPTION_BASEBALL_NUMBERS_SIZE_MESSAGE);
        }
    }

    private void isDuplicate(List<BaseballNumber> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_MAX_SIXE) {
            throw new IllegalArgumentException(EXCEPTION_BASEBALL_NUMBERS_DUPLICATE_MESSAGE);
        }
    }
}
