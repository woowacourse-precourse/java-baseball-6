package baseball.model;

import java.util.*;
import java.util.stream.Collectors;

import static baseball.exception.ErrorMessage.DUPLICATED_USER_NUMBER;
import static baseball.exception.ErrorMessage.INVALID_USER_NUMBER_CONTAINS_ZERO;


public class UserNumber {
    private final List<Integer> numbers;
    private static final int NUMBERS_SIZE = 3;

    private UserNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumber from(List<Integer> numbers) {
        validateNonZero(numbers);
        validateDuplicate(numbers);
        validateSize(numbers);
        return new UserNumber(numbers);
    }

    private static void validateNonZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER_CONTAINS_ZERO.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_USER_NUMBER.getMessage());
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_USER_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
