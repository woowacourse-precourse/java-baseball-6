package baseball.dto;

import baseball.validator.InputValidator;
import java.util.ArrayList;
import java.util.List;

public class GameNumber {

    private final List<Integer> numbers;

    public GameNumber(String input) {
        InputValidator.validateInputNumber(input);
        this.numbers = inputToNumbers(input);
    }

    public static List<Integer> inputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (Character c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
