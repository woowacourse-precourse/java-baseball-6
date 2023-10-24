package baseball.util;

import java.util.List;

public final class Validator {
    public static void validateListSize(List<Integer> list, int size) throws IllegalArgumentException {
        if(list.size() != size) {
            throw new IllegalArgumentException("리스트의 크기는 3이어야 합니다!");
        }
    }
}
