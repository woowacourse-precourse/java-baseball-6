package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {
    final static int INPUT_LOWER_BOUND = 100;
    final static int INPUT_UPPER_BOUND = 999;

    private String getUserInput() {
        return Console.readLine();
    }

    public boolean validateUserGuessInput(String userInput) {
        checkStringLengthEqualToTarget(userInput, 3);
        int userInt = convertStringToInteger(userInput);
        checkIntegerInRange(userInt, 100, 999);
        isDuplicatedInputGuess(userInput);
        return true;
    }

    private int convertStringToInteger(String userInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIntegerInRange(int input, int startInclusive, int endInclusive) throws IllegalArgumentException {
        if (input < startInclusive && input > endInclusive) {
            throw new IllegalArgumentException();
        }
    }

    private void checkStringLengthEqualToTarget(String input, int target) throws IllegalArgumentException {
        if (input.length() != target) {
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicatedInputGuess(String userInput) throws IllegalArgumentException {
        char firstNumber = userInput.charAt(0);
        char secondNumber = userInput.charAt(1);
        char thirdNumber = userInput.charAt(2);
        if (firstNumber == secondNumber || secondNumber == thirdNumber || firstNumber == thirdNumber) {
            throw new IllegalArgumentException();
        }
    }
}
