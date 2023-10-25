package baseball;

import java.util.List;

public class Number {

    private final List<Integer> number;

    public Number(List<Integer> number) {
        this.number = number;
    }

    public void validate() {
        validateRangeForAll();
        validateSize();
        validateDuplication();

    }

    public void validateRangeForAll() {
        for (int elem : number) {
            validateRange(elem);
        }
    }

    public void validateRange(int num) {
        if (num < 1 || num > 9) {
            throw new IllegalArgumentException("숫자는 1~9범위이여야 합니다.");
        }
    }

    public void validateSize() {
        if (number.size() != 3) {
            throw new IllegalArgumentException("3자리 수 숫자여야 합니다.");
        }
    }

    public void validateDuplication() {
        if (number.size() != number.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }
}
