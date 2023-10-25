package baseball.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public void validateInput(List<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("입력은 3개의 숫자여야 합니다.");
        }

        Set<Integer> numberSet = new HashSet<>(input);
        if (numberSet.size() != 3 || numberSet.contains(null) || numberSet.contains(0) || numberSet.contains(10)) {
            throw new IllegalArgumentException("입력은 1부터 9까지의 중복되지 않는 숫자여야 합니다.");
        }
    }
}
