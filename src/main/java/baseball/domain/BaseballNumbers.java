package baseball.domain;

import static baseball.console.Constant.EXCEPTION_BASEBALL_NUMBERS_DUPLICATE_MESSAGE;
import static baseball.console.Constant.EXCEPTION_BASEBALL_NUMBERS_SIZE_MESSAGE;
import static baseball.console.Constant.INT_ZERO;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumbers that = (BaseballNumbers) o;
        return NUMBERS_MAX_SIXE == (int) IntStream.range(INT_ZERO, NUMBERS_MAX_SIXE)
                .filter(i -> this.numbers.get(i).equals(that.numbers.get(i)))
                .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    int getStrikeCount(BaseballNumbers o) {
        return (int) IntStream.range(INT_ZERO, NUMBERS_MAX_SIXE)
                .filter(i -> numbers.get(i).equals(o.numbers.get(i)))
                .count();
    }

    int getBallCount(BaseballNumbers o) {
        return (int) IntStream.range(INT_ZERO, NUMBERS_MAX_SIXE)
                .filter(i -> !numbers.get(i).equals(o.numbers.get(i)) &&
                        o.numbers.stream()
                                .filter(j -> j.equals(this.numbers.get(i)))
                                .count() == 1)
                .count();
    }
}
