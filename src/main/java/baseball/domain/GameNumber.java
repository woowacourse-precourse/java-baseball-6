package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumber {

    private final List<Integer> number;

    public GameNumber(List<Integer> number) {
        checkNumber(number);
        this.number = number;
    }

    private void checkNumber(List<Integer> number) {
        checkLength(number);
        checkDuplicate(number);
        checkZero(number);
        checkNegative(number);
    }

    public List<Integer> getNumber() {
        return number;
    }

    private void checkLength(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해 주세요.");
        }
    }

    private void checkDuplicate(List<Integer> number) {
        Set<Integer> set = new HashSet<>(number);
        if (set.size() != number.size()) {
            throw new IllegalArgumentException("중복 되지 않는 숫자를 입력해 주세요.");
        }
    }

    private void checkZero(List<Integer> number) {
        if (number.contains(0)) {
            throw new IllegalArgumentException("0은 포함할 수 없습니다.");
        }
    }

    private void checkNegative(List<Integer> number) {
        for (Integer i : number) {
            if (i < 0) {
                throw new IllegalArgumentException("음수는 포함할 수 없습니다.");
            }
        }
    }
}
