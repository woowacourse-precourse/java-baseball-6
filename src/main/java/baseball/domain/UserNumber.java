package baseball.domain;

import baseball.util.exception.IllegalArgumentExceptionType;
import baseball.util.exception.IllegalStateExceptionType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserNumber {
    private List<Integer> numbers;

    private UserNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumber of(String numbers) {
        List<Integer> parseNumbers = parseNumbers(numbers);
        validateNumbers(parseNumbers);
        return new UserNumber(parseNumbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void updateUserNumber(String numbers) {
        List<Integer> parseNumbers = parseNumbers(numbers);
        validateNumbers(parseNumbers);
        this.numbers = parseNumbers;
    }

    private static void validateNumbers(final List<Integer> numbers) {
        emptyCheck(numbers);
        uniqueCheck(numbers);
        lengthCheck(numbers);
    }

    private static void lengthCheck(final List<Integer> numbers) {
        lengthLower(numbers);
        if (numbers.size() > 3) {
            throw IllegalArgumentExceptionType.INVALID_INPUT.getException();
        }
    }

    private static void lengthLower(final List<Integer> numbers) {
        if (numbers.size() < 3) {
            throw IllegalArgumentExceptionType.INVALID_INPUT.getException();
        }
    }

    private static void uniqueCheck(final List<Integer> numbers) {
        Set<Integer> uniqueInput = new HashSet<>(numbers);
        if (numbers.size() != uniqueInput.size()) {
            throw IllegalStateExceptionType.DUPLICATE_INPUT.getException();
        }
    }

    private static void emptyCheck(final List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw IllegalArgumentExceptionType.INVALID_INPUT.getException();
        }
    }

    private static List<Integer> parseNumbers(final String numbers) {
        return numbers.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
