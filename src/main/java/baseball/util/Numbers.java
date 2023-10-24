package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(Number number) {
        if (number != null) {
            this.numbers.add(number);
        }
    }

    public boolean validateSize() {
        return this.numbers.size() == 3;
    }

    public void checkDuplicate(Number number) {
        if (this.numbers.contains(number)) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
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
        return -1;
    }
}
