package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumbers {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public GameNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || MAX_NUMBER < number) {
                throw new IllegalArgumentException(String.format("%d~%d 범위의 숫자를 입력해주세요.", MIN_NUMBER, MAX_NUMBER));
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자들은 중복될 수 없습니다.");
        }
    }
}
