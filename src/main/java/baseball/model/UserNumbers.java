package baseball.model;

import static baseball.ErrorMessage.DUPLICATED_NUMBER;
import static baseball.ErrorMessage.INVALID_SIZE;
import static baseball.ErrorMessage.NOT_NUMBER;
import static baseball.NumericRange.COUNT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserNumbers {

    private List<Integer> userNumbers;

    private UserNumbers(final List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public static UserNumbers createUserNumbers(final List<String> stringNumbers) {
        List<Integer> numbers = parseNumbersToInteger(stringNumbers);
        validateNumbersSize(numbers);
        validateDuplicate(numbers);
        return new UserNumbers(numbers);
    }

    private static List<Integer> parseNumbersToInteger(final List<String> stringNumbers) {
        try {
            return stringNumbers.stream()
                .map(Integer::parseInt)
                .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private static void validateDuplicate(final List<Integer> inputNumbers) {
        int numbersSize = new HashSet<>(inputNumbers).size();
        if (inputNumbers.size() > numbersSize) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateNumbersSize(final List<Integer> inputNumbers) {
        if (inputNumbers.size() != COUNT.getNumber()) {
            throw new IllegalArgumentException(INVALID_SIZE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(userNumbers);
    }
}
