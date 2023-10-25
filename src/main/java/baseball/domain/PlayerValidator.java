package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerValidator {

    public static final String NUMBER_SIZE_EX_MESSAGE = "입력값은 세 자리의 숫자여야 합니다.\n";
    public static final String NUMBER_NOT_DUPLICATED_EX_MESSAGE = "입력값은 중복되는 수가 하나라도 없어야 합니다.\n";
    public static final String NUMBER_RANGE_EX_MESSAGE = "모든 숫자는 1에서 9 사이의 값을 가져야 합니다.\n";
    public static final String NUMBER_NULL_EX_MESSAGE = "입력값이 null이 될 수 없습니다.\n";


    public static void validate(List<Integer> numbers) {
        validateNotNull(numbers);
        validateNumberSize(numbers);
        validateNotDuplicated(numbers);
        validateNumberRange(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != Referee.NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EX_MESSAGE);
        }
    }

    private static void validateNotDuplicated(List<Integer> numbers) {
        Set<Integer> checkDuplicateNumbers = new HashSet<>(numbers);
        if (checkDuplicateNumbers.size() != Referee.NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBER_NOT_DUPLICATED_EX_MESSAGE);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException(NUMBER_RANGE_EX_MESSAGE);
            }
        }
    }

    private static void validateNotNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(NUMBER_NULL_EX_MESSAGE);
        }
    }
}
