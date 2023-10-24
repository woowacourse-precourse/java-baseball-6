package baseball.validation;

import java.util.*;

import static baseball.domain.GameRules.*;

public class PickNumberValidation {
    private PickNumberValidation() { }

    private static final String NUMBER_REGEX = "[1-9]+";
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
//        List<String> picksSet = new ArrayList<>(Arrays.asList(pickNumber));
        Set<Integer> picksHashSet = new HashSet<>(pickNumbers);
        if(picksHashSet.size() != INPUT_LIMIT.getValue()) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
        }
    }

}
