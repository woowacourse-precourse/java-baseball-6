package baseball.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public InputValidator() {}

    public boolean isNumeric(String input) {
        return Arrays.stream(input.split(""))
                .allMatch(s -> s.matches("^[0-9]+$"));
    }

    public boolean isValidLength(List<Integer> numbers, int length) {
        return numbers.size() == length;
    }

    public boolean isUniqueDigits(List<Integer> numbers) {
        Set<Integer> deduplicatedNumbers = new HashSet<>(numbers);

        return deduplicatedNumbers.size() == numbers.size();
    }

    public boolean isValidRange(List<Integer> numbers, int min, int max) {
        return numbers.stream()
                .allMatch(number -> number >= min && number <= max);
    }
}
