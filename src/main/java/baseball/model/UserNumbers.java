package baseball.model;

import static baseball.Constants.NUMBER_COUNTS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserNumbers {

    private List<Integer> userNumbers;

    private UserNumbers(final List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public static UserNumbers createUserNumbers(final List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicate(numbers);
        return new UserNumbers(numbers);
    }

    private static void validateDuplicate(final List<Integer> inputNumbers) {
        int numbersSize = new HashSet<>(inputNumbers).size();
        if (inputNumbers.size() > numbersSize) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumbersSize(final List<Integer> inputNumbers) {
        if (inputNumbers.size() != NUMBER_COUNTS) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(userNumbers);
    }
}
