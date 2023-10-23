package baseball.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.domain.GameRules.INPUT_LIMIT;

public class InvalidPickException {
    private static final String NUMBER_REGEX = "[1-9]+";
    public void checkValidInput(String pickNumber) {
        isNumberRange(pickNumber);
        isNumeric(pickNumber);
        isOverlapNumber(pickNumber);
    }
    public void isNumberRange(String pickNumber) {
        if(pickNumber.length() != INPUT_LIMIT.getValue()) {
            throw new IllegalArgumentException("3개의 수를 입력해주세요.");
        }
    }
    public void isNumeric(String pickNumber) {
        if(pickNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("1~9의 숫자만 입력해주세요.");
        }
    }
    public void isOverlapNumber(String pickNumber) {
        Set<String> picksSet = new HashSet<>();
        Set<String> picksHashSet = new HashSet<>(Arrays.asList(pickNumber));
        if(picksSet.size() != picksHashSet.size()) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
        }
    }

}
