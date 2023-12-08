package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersValidator {

    public static void validateNumbersSize(int validSize, List<Integer> numbers) {
        if (numbers.size() != validSize) {
            throw new IllegalArgumentException(String.format("[ERROR] 숫자는 %d개이어야 합니다.", validSize));
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
        }
    }

    public static void validateContainsZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("[ERROR] 0은 입력할 수 없습니다.");
        }
    }
}
