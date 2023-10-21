package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final int SIZE = 3;

    private List<Integer> numbers;

    public void inputNumbers() {
        numbers = new ArrayList<>();

        String input = Console.readLine();
        validateInput(input);

        List<Integer> inputNumbers = inputToNumbers(input);
        validateNumbers(inputNumbers);

        numbers = inputNumbers;
    }

    private List<Integer> inputToNumbers(final String input) {
        final List<Integer> result = new ArrayList<>();
        for (int index = 0; index < input.length(); index++) {
            int number = characterToInteger(input.charAt(index));
            result.add(number);
        }
        return result;
    }

    private int characterToInteger(final char character) {
        return character - '0';
    }

    private void validateInput(final String input) {
        if (input.length() != SIZE) {
            throw new IllegalArgumentException();
        }
        for (int index = 0; index < input.length(); index++) {
            char character = input.charAt(index);
            isDigit(character);
        }
    }

    private void isDigit(final char character) {
        if (!Character.isDigit(character)) {
            throw new IllegalArgumentException("not a number");
        }
    }

    private void validateNumbers(final List<Integer> inputNumbers) {
        Set<Integer> result = new HashSet<>(inputNumbers);
        if (result.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
