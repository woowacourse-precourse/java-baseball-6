package baseball.util;

import java.util.List;

public class Util {

    protected Util() {}
    public static boolean validNumberType(Object o) {
        if (o instanceof Integer) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    public static boolean validNumberRange(int min, int max, int value) {
        if (value >= min && value <= max) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    public static boolean validDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다.");
        }
        return true;
    }

    public static boolean validNumbersCount(List<Integer> numbers, int size) {
        if (numbers.size() == size) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }
}
