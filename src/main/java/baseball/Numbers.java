package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    Numbers() {
        numbers = new ArrayList<>();
    }

    public void addNumber(Number number) {
        validateDuplicatedNumber(number);
        numbers.add(number);
    }

    public void validateDuplicatedNumber(Number number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요");
        }
    }

    public Number getNumberByIndex(int index) {
        return numbers.get(index);
    }
}
