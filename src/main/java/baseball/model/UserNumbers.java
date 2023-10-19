package baseball.model;

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

        userNumbers = inputNumbers;
    }
}
