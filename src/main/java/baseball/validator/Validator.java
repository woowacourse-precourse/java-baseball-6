package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateOverlap(List<Integer> playerNumbers) {
        Set<Integer> noOverlapNumbers = new HashSet<>(playerNumbers);
        if (noOverlapNumbers.size() != playerNumbers.size()) {
            throw new IllegalArgumentException("서로 다른 수를 입력해야 합니다.");
        }
    }
}
