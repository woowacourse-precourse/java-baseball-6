package baseball.number;

import baseball.util.NumbersComparator;
import baseball.result.Result;
import java.util.List;

public class Numbers {
    List<Number> numbers;
    static final int MAX_SIZE = 3;
    static final int NOT_INCLUDE = -1;

    public Numbers(List<Number> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
        this.numbers = numbers;
    }

    public Result compareWith(Numbers other) {
        return new NumbersComparator().compareWith(this, other);
    }

    public Number getNumber(int index) {
        return numbers.get(index);
    }

    public int includeNumber(Number number) {
        if (numbers.contains(number)) {
            return numbers.indexOf(number);
        }
        return NOT_INCLUDE;
    }
}
