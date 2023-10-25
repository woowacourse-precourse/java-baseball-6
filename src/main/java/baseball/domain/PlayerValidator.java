package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerValidator {

    public static final String NUMBER_SIZE_EX_MESSAGE = "입력값은 세 자리의 숫자여야 합니다.\n";
    public static final String NUMBER_NOT_DUPLICATED_EX_MESSAGE = "입력값은 중복되는 수가 하나라도 있으면 안됩니다.\n";


    public static void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNotDuplicated(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(NUMBER_SIZE_EX_MESSAGE);
        }
    }

    private static void validateNotDuplicated(List<Integer> numbers) {
        Set<Integer> checkDuplicateNumbers = new HashSet<>(numbers);
        if (checkDuplicateNumbers.size() != 3) {
            throw new IllegalArgumentException(NUMBER_NOT_DUPLICATED_EX_MESSAGE);
        }
    }
}
