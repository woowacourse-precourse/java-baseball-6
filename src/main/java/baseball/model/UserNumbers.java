package baseball.model;

import baseball.util.Converter;

import java.util.List;

public class UserNumbers {

    private final List<Integer> numbers;

    private UserNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumbers fromList(final String input) {
        List<Integer> numbers = Converter.convertStringToIntegerList(input);
        return new UserNumbers(numbers);
    }
}
