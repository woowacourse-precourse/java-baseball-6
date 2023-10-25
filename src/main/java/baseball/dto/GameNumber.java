package baseball.dto;

import baseball.validator.InputValidator;
import java.util.ArrayList;
import java.util.List;

public class GameNumber {

    private final List<Integer> numbers;

    private GameNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static GameNumber makeGameNumberByInput(String input) {
        InputValidator.validateInputNumber(input);
        return new GameNumber(inputToNumbers(input));
    }

    private static List<Integer> inputToNumbers(String input) {
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
