package baseball.util;

import baseball.constant.GameRule;
import java.util.Arrays;

public class InputValidator {

    public boolean validateHasNoChar(String userInput) {
        return userInput.matches("[0-9]+");
    }

    public boolean validateRetryInput(String userInput) {
        return validateIsElementOneOrTwo(userInput) && validateIsOnlyOneElement(userInput);
    }

    public boolean validateParsedInput(int[] parsedUserInput) {
        return validateNoDuplication(parsedUserInput) && validateHasSameDigit(parsedUserInput)
            && validateHasNoZero(parsedUserInput);
    }

    private boolean validateIsElementOneOrTwo(String userInput) {
        return (userInput.equals("1")) || (userInput.equals("2"));
    }

    private boolean validateIsOnlyOneElement(String userInput) {
        return userInput.length() == 1;
    }

    private boolean validateNoDuplication(int[] userInput) {
        return userInput.length == Arrays.stream(userInput).distinct().count();
    }

    private boolean validateHasSameDigit(int[] parsedUserInput) {
        return parsedUserInput.length == GameRule.DIGIT;
    }

    private boolean validateHasNoZero(int[] parsedUserInput) {
        return Arrays.stream(parsedUserInput).noneMatch(element -> element == 0);
    }
}
