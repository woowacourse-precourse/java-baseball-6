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
        for (int i = Constant.COUNT_ZERO; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (userInput.indexOf(c) != userInput.lastIndexOf(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsInvalidNumber(String userInput) {
        for (char c : userInput.toCharArray()) {
            int number = Character.getNumericValue(c);
            if (number < Constant.RANDOM_NUMBER_START || number > Constant.RANDOM_NUMBER_END) {
                return true;
            }
        }
        return false;
    }
}
