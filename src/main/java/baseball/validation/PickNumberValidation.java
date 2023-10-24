package baseball.validation;

import java.util.*;

import static baseball.domain.GameRules.*;

public class PickNumberValidation {
    private PickNumberValidation() { }
    public static void checkValidInput(List<Integer> pickNumbers) {
        isNumberRange(pickNumbers);
        isDuplicate(pickNumbers);
    }
    private static void isNumberRange(List<Integer> pickNumbers) {
        if(pickNumbers.size() != INPUT_LIMIT.getValue()) {
            throw new IllegalArgumentException("3개의 수를 입력해주세요.");
        }
    }
    private static void isDuplicate(List<Integer> pickNumbers) {
        Set<Integer> picksHashSet = new HashSet<>(pickNumbers);
        if(picksHashSet.size() != INPUT_LIMIT.getValue()) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
        }
    }

}
