package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumber {
    private static final int NUMBER_LENGTH = 3;
    private static final String ZERO = "0";

    private final List<Integer> numbers;

    public GameNumber(String input) {
        validate(input);
        numbers = toNumbers(input);
    }

    public GameNumber(Set<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(String input) {
        validateLength(input);
        validateValidNumber(input);
        validateDuplication(input);
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateValidNumber(String input) {
        isNumber(input);
        isContainingZero(input);
    }

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void isContainingZero(String input) {
        if (input.contains(ZERO)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(String input) {
        List<Character> list = new ArrayList<>();
        for (char ch :input.toCharArray()){
            list.add(ch);
        }

        if (list.size() != new HashSet<>(list).size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> toNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            numbers.add(Character.getNumericValue(number));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
