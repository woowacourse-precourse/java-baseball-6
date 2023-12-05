package baseball.utils.validator;

import baseball.global.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.exception.ErrorMessage.*;

public class UserNumberValidator {
    private static final int INVALID_NUMBER = 0;

    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER_INPUT_FORMAT.getMessage());
        }
    }

    public static List<Integer> convertToIntegerList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void validateNonZero(List<Integer> numbers) {
        if (numbers.contains(INVALID_NUMBER)) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER_CONTAINS_ZERO.getMessage());
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_USER_NUMBER.getMessage());
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constants.NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_USER_NUMBER.getMessage());
        }
    }
}
