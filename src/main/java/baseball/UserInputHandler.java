package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {

    public List<Integer> getUserGuess() {
        String userInput = Console.readLine();
        validateUserGuessInput(userInput);
        return convertGuessToList(userInput);
    }

    public Boolean askUserRestart() {
        String userInput = Console.readLine();
        int userInt = validateUserRestartInput(userInput);
        return returnRestartInput(userInt);
    }

    private List<Integer> convertGuessToList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char eachCharInput = userInput.charAt(i);
            int eachIntInput = Character.getNumericValue(eachCharInput);
            userInputList.add(eachIntInput);
        }
        return userInputList;
    }

    private int validateUserRestartInput(String userInput) throws IllegalArgumentException {
        checkStringLengthEqualToTarget(userInput, 1);
        int userInt = convertStringToInteger(userInput);
        checkIntegerInRange(userInt, 1, 2);
        return userInt;
    }

    private Boolean returnRestartInput(int input) {
        return input == 1;
    }

    public boolean validateUserGuessInput(String userInput) {
        checkStringLengthEqualToTarget(userInput, 3);
        int userInt = convertStringToInteger(userInput);
        checkIntegerInRange(userInt, 100, 999);
        isDuplicatedInputGuess(userInput);
        return true;
    }

    private int convertStringToInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIntegerInRange(int input, int startInclusive, int endInclusive) {
        if (input < startInclusive && input > endInclusive) {
            throw new IllegalArgumentException();
        }
    }

    private void checkStringLengthEqualToTarget(String input, int target) {
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
