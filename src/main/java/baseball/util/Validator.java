package baseball.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {
    public static void validateListSize(List<Integer> list, int size) {
        if(list.size() != size) {
            throw new IllegalArgumentException("리스트의 크기는 3이어야 합니다!");
        }
    }

    public static void validateDuplicateList(List<Integer> list) {
        Set<Integer> validationList = new HashSet<>(list);
        if (validationList.size() != list.size()) {
            throw new IllegalArgumentException("리스트에 중복된 숫자가 존재합니다.");
        }
    }
}
