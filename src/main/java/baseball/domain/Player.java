package baseball.domain;

import baseball.exception.ErrorMessage;
import baseball.exception.InvalidInputException;

import java.util.List;

public class Player {
    private List<Integer> guessedNumbers;

    public List<Integer> getGuessedNumbers() {
        return guessedNumbers;
    }

    public List<Integer> guessNumbers(String input) {
        List<Integer> numbers = parseInputToIntegerList(input);
        validateBaseballNumbersFormat(numbers);
        this.guessedNumbers = numbers;
        return numbers;
    }

    private List<Integer> parseInputToIntegerList(String input) {
        validateIsDigit(input);
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    private void validateIsDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new InvalidInputException(ErrorMessage.INVALID_INPUT_NUMBER);
        }
    }

    private void validateBaseballNumbersFormat(List<Integer> numbers) {
        Baseball.validateNumbers(numbers);
    }
}
