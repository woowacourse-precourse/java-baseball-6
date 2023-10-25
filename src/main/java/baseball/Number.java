package baseball;

import java.util.List;

public class Number {

    protected static final int MINRANGE = 1;
    protected static final int MAXRANGE = 9;
    protected static final int SIZE = 3;


    public void validate(List<Integer> number) {
        validateRangeForAll(number);
        validateSize(number);
        validateDuplication(number);
    }

    public void validateRangeForAll(List<Integer> number) {
        for (int elem : number) {
            validateRange(elem);
        }
    }

    public void validateRange(int num) {
        if (num < MINRANGE || num > MAXRANGE) {
            throw new IllegalArgumentException("숫자는 1~9범위이여야 합니다.");
        }
    }

    public void validateSize(List<Integer> number) {
        if (number.size() != SIZE) {
            throw new IllegalArgumentException("3자리 수 숫자여야 합니다.");
        }
    }

    public void validateDuplication(List<Integer> number) {
        if (number.size() != number.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }
}
