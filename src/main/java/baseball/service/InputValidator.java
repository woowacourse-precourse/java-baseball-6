package baseball.service;

public class InputValidator {

    public void validate(String userInput) {
        if (isNotThreeDigits(userInput) || containsDuplicateNumber(userInput)
                || containsInvalidNumber(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotThreeDigits(String userInput) {
        return userInput.length() != 3;
    }

    private boolean containsDuplicateNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (userInput.indexOf(c) != userInput.lastIndexOf(c)) {
                return false;
            }
        }
        return false;
    }

    private boolean containsInvalidNumber(String userInput) {
        for (char c : userInput.toCharArray()) {
            int number = Character.getNumericValue(c);
            if (number < 1 || number > 9) {
                return true;
            }
        }
        return false;
    }
}
