package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballInputView {

    public List<Integer> userGuessInput() {
        String input = Console.readLine();
        validateInputLength(input);
        
        List<Integer> userInput = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            validateInputInteger(currentChar);
            int digit = Character.getNumericValue(currentChar);
            validateNoDuplicates(userInput, digit);
            userInput.add(digit);
        }
        return userInput;
    }

    public Integer userProgressInput() {
        String input = Console.readLine();
        validateInputChoice(input);
        return Integer.parseInt(input);
    }

    private void validateInputChoice(String input) {
        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException("Input must be either 1 or 2.");
        }
    }

    private void validateInputInteger(char currentChar) {
        if (!Character.isDigit(currentChar)) {
            throw new IllegalArgumentException("Input must only contain numbers");
        }
    }

    private void validateNoDuplicates(List<Integer> list, int element) {
        if (list.contains(element)) {
            throw new IllegalArgumentException("There must be no duplicate number");
        }
    }

    private void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("Input length must be 3 length long");
        }
    }
}
