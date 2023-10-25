package baseball.domain;

import baseball.console.Constant;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * 컴퓨터와 사용자의 3자리 숫자를 나타내는 클래스.
 * 생성 시 숫자의 사이즈와 숫자의 중복 여부를 검증한다. 컴퓨터와 사용자의 수를 비교하여 스트라이크, 볼, 낫싱의 여부를 판단하기 위한 계산 기능을 가진다.
 */
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
            throw new IllegalArgumentException(Constant.EXCEPTION_BASEBALL_NUMBERS_SIZE_MESSAGE);
        }
    }

    private void isDuplicate(List<BaseballNumber> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_MAX_SIXE) {
            throw new IllegalArgumentException(Constant.EXCEPTION_BASEBALL_NUMBERS_DUPLICATE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        BaseballNumbers that = (BaseballNumbers) other;
        return NUMBERS_MAX_SIXE == (int) IntStream.range(Constant.INT_ZERO, NUMBERS_MAX_SIXE)
                .filter(i -> this.numbers.get(i).equals(that.numbers.get(i)))
                .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    int getStrikeCount(BaseballNumbers o) {
        return (int) IntStream.range(Constant.INT_ZERO, NUMBERS_MAX_SIXE)
                .filter(i -> numbers.get(i).equals(o.numbers.get(i)))
                .count();
    }

    int getBallCount(BaseballNumbers o) {
        return (int) IntStream.range(Constant.INT_ZERO, NUMBERS_MAX_SIXE)
                .filter(i -> !numbers.get(i).equals(o.numbers.get(i)) &&
                        o.numbers.stream()
                                .filter(j -> j.equals(this.numbers.get(i)))
                                .count() == 1)
                .count();
    }
}
