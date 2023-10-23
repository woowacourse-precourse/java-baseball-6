package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserInputValidator {

    public List<Integer> validateUserInput(String userInput) {
        if (isInvalidInput(userInput)) {
            throw new IllegalArgumentException("Invalid user input");
        }
        return parseUserInput(userInput);
    }

    private boolean isInvalidInput(String userInput) {
        return userInput == null
                || userInput.trim().isEmpty()
                || !userInput.matches("^[0-9]{3}$")
                || Integer.parseInt(userInput) < 0
                || hasDuplicateDigits(userInput);
    }

    private boolean hasDuplicateDigits(String userInput) {
        return userInput.chars()
                .distinct()
                .count() != userInput.length();
    }

    private List<Integer> parseUserInput(String userInput) {
        return userInput.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
