package baseball.model;

import static baseball.Constants.NUMBER_COUNTS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserNumbers {

    private List<Integer> userNumbers;

    private UserNumbers(final List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public static UserNumbers of(String numbers) {
        List<Integer> inputNumbers = Arrays.stream(numbers.split(""))
            .map(Integer::parseInt)
            .toList();

        validateNumbersSize(inputNumbers);
        return new UserNumbers(inputNumbers);
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
