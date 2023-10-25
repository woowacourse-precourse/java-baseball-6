package baseball.validator;

import java.util.List;

public final class ListValidators {

    public static <T> void validateDistinct(List<T> objects) {
        int entireSize = objects.size();
        int distinctSize = (int) objects.stream()
                .distinct()
                .count();

        if (entireSize != distinctSize) {
            throw new IllegalArgumentException("중복된 값이 존재합니다");
        }
    }

    public static <T> void validateSize(List<T> objects, int size) {
        int currentSize = objects.size();
        if (currentSize != size) {
            throw new IllegalArgumentException("요소의 수가 유효하지 않습니다");
        }
    }

}
