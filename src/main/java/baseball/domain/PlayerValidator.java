package baseball.domain;

import java.util.List;

public class PlayerValidator {

    public static final String NUMBER_SIZE_EX_MESSAGE = "입력값은 세 자리의 숫자여야 합니다.\n";

    public static void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(NUMBER_SIZE_EX_MESSAGE);
        }
    }
}
