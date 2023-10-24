package baseball.validator;

import java.util.List;

public class Validator {
    public static void validateSize(String str, int length) {
        if (str.length() != length) {
            throw new IllegalArgumentException("문자열의 길이가 올바르지 않습니다.");
        }
    }

    public static void validateSize(List<Integer> integerList, int size) {
        if (integerList.size() != size) {
            throw new IllegalArgumentException("리스트의 길이가 올바르지 않습니다.");
        }
    }

    public static void validateNull(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Null이 입력되었습니다.");
        }
    }

    public static void validateInRange(int target, int startInclusive, int endInclusive) {
        if (!(startInclusive <= target && target <= endInclusive)) {
            throw new IllegalArgumentException("올바른 범위의 수가 아닙니다.");
        }
    }
}
