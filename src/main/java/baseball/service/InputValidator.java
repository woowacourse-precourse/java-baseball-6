package baseball.service;

import baseball.utils.Constant;

public class InputValidator {

    public void validate(String userInput) {
        if (isNotThreeDigits(userInput) || containsDuplicateNumber(userInput)
                || containsInvalidNumber(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotThreeDigits(String userInput) {
        return userInput.length() != Constant.RANDOM_NUMBER_SIZE;
    }

    private boolean containsDuplicateNumber(String userInput) {
        return userInput.chars()
                .distinct()
                .count() != userInput.length();
    }

    private boolean containsInvalidNumber(String userInput) {
        return userInput.chars()
                .map(Character::getNumericValue)
                .anyMatch(number -> number < Constant.RANDOM_NUMBER_START
                        || number > Constant.RANDOM_NUMBER_END);
    }
}
