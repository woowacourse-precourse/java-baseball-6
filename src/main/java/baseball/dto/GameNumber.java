package baseball.dto;

import baseball.model.Computer;
import baseball.validator.InputValidator;
import baseball.exception.InvalidIndexException;
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

    public Integer getNumberAt(Integer index) {
        if (index < Computer.NUMBER_DIGIT) {
            return numbers.get(index);
        }
        throw new InvalidIndexException();
    }
}
