package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserInputValidator {

    public List<Integer> isValidUserInput(String userInput) {
        if (userInput == null
                || userInput.trim().isEmpty()
                || !userInput.matches("^[0-9]{3}$")
                || Integer.parseInt(userInput) < 0
                || hasDuplicateDigits(userInput)) {
            throw new IllegalArgumentException();
        }else{
            return userInputSlice(Integer.parseInt(userInput));
        }
    }

    private boolean hasDuplicateDigits(String userInput) {
        return userInput.chars()
                .distinct()
                .count() != userInput.length();
    }

    private List<Integer> userInputSlice(int userInput) {
        return String.valueOf(userInput).chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
