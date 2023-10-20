package baseball;

import static baseball.Constants.SIZE_OF_DIGITS;

public class UserInputValidator {
    public void checkValid(String userInput) {
        if (!isValid(userInput)) {
            throw new IllegalArgumentException();
        }
    }
    private boolean isValid(String input) {
        return isInputSizeValid(input) && !isInputDuplicated(input);
    }

    private boolean isInputSizeValid(String input) {
        return input.length() == SIZE_OF_DIGITS.getValue();
    }

    private boolean isInputDuplicated(String input) {
        return input.chars().distinct().count() != input.length();
    }
}
